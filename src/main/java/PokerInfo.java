import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Arrays;
import java.lang.Math;

public class PokerInfo implements Serializable {
    int[][] deck = new int[4][13];  // the deck of cards
    int[][] playersHand = new int[2][3]; // first row of array tracks the suit of the card, second row is the actual card value
    int[][] dealersHand = new int[2][3]; // first row of array tracks the suit of the card, second row is the actual card value
    int playersHighestCard = 0; // used to keep track of the highest order card in the hand of the player
    int dealersHighestCard = 0; // used to keep track of the highest order card for the dealer
    int numberOfWins, totalEarnings, currentEarnings, ante, wager, pairPlus, playerRanking, dealerRanking;
    boolean hasUserFolded, hasUserWon;

    // Constructor for the poker class
    public PokerInfo(int ante, int wager, int pairPlus) {
        this.numberOfWins = 0;
        this.totalEarnings = 0;
        this.currentEarnings = 0;
        this.hasUserFolded = false;
        this.ante = ante;
        this.wager = wager;
        this.pairPlus = pairPlus;
    }

    // Function to calculate the highest rank for the cards that user and the dealer have
    public int calculateHighestRank(int [][] hand, int highOrder){
        // determine if the user's cards all have the same suit (elimates possibility of straight flush/flush)
        if(isSameSuit(hand)){
            if(isInOrder(hand)){
                System.out.println("Congrats, you got a straight flush! Add more to this condition");
                return 5;
            }
            else{
                System.out.println("Congrats, you got a flush! Add more to this condition");
                return 2;
            }
        }
        // determine if the user's cards are all the same (elimates possiblity of three of a kind)
        else if(isSameCard(hand)){
            System.out.println("You got a three of a kind! Add more to this condition!");
            return 4;
        }

        // determine if the user has cards that are in order by value (eliminates possiblily of straight)
        else if(isInOrder(hand)){
            System.out.println("Congrats, you got a straight! Add more to this condition");
            return 3;
        }
        else if(hasPair(hand)){
            System.out.println("Congrats, you got a pair!");
            return 1;
        }

        else{
            highOrder = highestValueCard(hand);
            return 0;
        }
    }

    // Function to determine if all the cards in the hand are the same suit. Return true if yes, returns false
    // otherwise.
    private boolean isSameSuit(int[][] usersCards){
        int suitNumber = usersCards[0][0]; // this contains the suit of the first card
        for(int i = 1; i < 3; i++){
            if(usersCards[0][i] != suitNumber){
                return false;
            }
        }
        return true;
    }

    // Function to determine if all the cards in the hand are of the same value.
    // Return true if yes, returns false otherwise
    private boolean isSameCard(int[][] usersCards){
        int card = usersCards[1][0];
        for(int i = 1; i < 3; i++){
            if(usersCards[1][i] != card){
                return false;
            }
        }
        return true;
    }

    // Function to determine if the cards in the hand are in order. Return true if yes, false if no.
    private boolean isInOrder(int [][] usersCards){
        int[] cardValues = new int[3];
        for(int i = 0; i < 3; i++){
            cardValues[i] = usersCards[1][i];
        }
        Arrays.sort(cardValues); // sorts the values of the array in ascending order
        // if cardValues at i is not plus one more than the cardValues at (i-1), they're not in order
        for(int i = 1; i < 3; i++){
            if(cardValues[i] != cardValues[i-1] + 1){
                return false;
            }
        }
        return true;
    }

    // Function to determine if the cards in the hand have a pair. Return true if yes, false if no.
    private boolean hasPair(int [][] usersCards){
        for(int i = 0; i < 3; i++){
            int suit = usersCards[0][i];
            for(int k = 0; k < 3; k++){
                // if the suits also match, that's just rereading the same card, skip it
                if(usersCards[0][k] == suit){
                    continue;
                }
                // if it matches anything else, you got a pair
                if(usersCards[1][i] == usersCards[1][k]){
                    return true;
                }
            }
        }
        return false;
    }

    // Function to determine the highest order card
    private int highestValueCard(int[][] usersCards){
        int[] cardValues = new int[3];
        for(int i = 0; i < 3; i++){
            cardValues[i] = usersCards[1][i];
        }

        return Arrays.stream(cardValues).max().getAsInt();
    }

    // Function to compare the dealer's hand and the player's hand
    public void compareHands(int [][] playersHand, int [][] dealersHand, int playersHighestCard, int dealersHighestCard) {
        this.playerRanking = calculateHighestRank(playersHand, playersHighestCard);
        this.dealerRanking = calculateHighestRank(dealersHand, dealersHighestCard);

        if(this.playerRanking < this.dealerRanking){
            System.out.println("Sorry! You Lost!");
            this.hasUserWon = false;
            // calculate money lost based on the player's bets
        }
        else if(this.playerRanking > this.dealerRanking){
            System.out.println("Congrats, you win!");
            this.hasUserWon = true;
            // calculate money won based on user's bets
        }
        else{
            System.out.println("Sorry, you tied. No money lost tho!");
            this.hasUserWon = false;
        }
    }

    // Funtion to load the deck for calculations, Hearts = index 0, Spades = index 1, Clubs = index 2, Diamonds = index 3
    // Aces are considered as card 1
    private void loadDeck(int[][] deck){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 14; j++){
                this.deck[i][j] = j+1;
            }
        }
    }

    // Function to determine the winnings that the user gets if they win
    public void determineWinningsCurrent(int wager, int ante, int pairPlus, boolean hasUserWon, boolean hasUserFolded){
        if(hasUserFolded){
            this.currentEarnings -= wager - ante - pairPlus;
        }
        else{
            if(hasUserWon){
                switch(this.playerRanking){
                    case 5: // straight flush 40 - 1
                        this.currentEarnings = 40 * (wager + ante + pairPlus);
                        break;
                    case 4: // three of a kind 30 - 1
                        this.currentEarnings = 30 * (wager + ante + pairPlus);
                        break;
                    case 3: // straight 6 - 1
                        this.currentEarnings = 6 * (wager + ante + pairPlus);
                        break;
                    case 2: // flush 3 - 1
                        this.currentEarnings = 3 * (wager + ante + pairPlus);
                        break;
                    case 1: // pair 1 -1 (double)
                        this.currentEarnings = 2 * (wager + ante + pairPlus);
                        break;
                    default: // high order (which I think they just get their money back);
                        this.currentEarnings = (wager + ante + pairPlus);
                        break;
                }
            }
            else{ // the user played but lost
                this.currentEarnings -= wager - ante - pairPlus;
            }
        }
    }

    // Function to update the hand of the user (and send it back to the client)
    private void updateHands(int[][] hand){
        int[][] usedSuits = new int[1][3];
        int[][] usedNumbers = new int[1][3];
        for(int i = 0; i < 3; i++){
            int newSuit = (int)(Math.random()) % 4;
            int newSuit = (int)(Math.random()) % 4;

            for(int k = 0; k < i; k++){
                if(usedSuits[k] == newSuit && usedNumbers[k] == newCard){
                    System.out.println("Card already used. Reshuffling");
                    newSuit = (int)(Math.random()) % 4;
                    newSuit = (int)(Math.random()) % 4;
                }
            }
        }
    }
}
