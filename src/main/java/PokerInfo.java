import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Arrays;

public class PokerInfo implements Serializable {
    private final ArrayList<Integer> dealersCards;
    //the players hand
    public Card cards[];
    private Random shuffler;
    private boolean fold;
    private int player_id;

    private int gamesPlay;
    private int numwin;
    private int playerAnte;
    private int playerPair;
    private int playerWage;

    // the deck of cards
    int[][] deck = new int[4][13];
    int[][] playersHand = new int[2][3];
    int[][] dealersHand = new int[2][3];
    int playersHighestCard = 0; // used to keep track of the highest order card in the hand of the player
    int dealersHighestCard = 0; // used to keep track of the highest order card for the dealer

    // Constructor for the poker class
    public PokerInfo(int p) {
        cards = new Card[5];
        this.dealersCards = new ArrayList<>();
        this.playerAnte = 0;
        this.player_id = 1;
        this.playerPair = 0;
        this.playerWage = 0;
        this.numwin = 0;
        this.gamesPlay = 0;
       // this.playersCards = new ArrayList<>();
        this.fold = false;
    }

    // Function to calculate the highest rank for the cards that user and the dealer have
    public static int calculateHighestRank(int [][] hand, int highOrder){
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
        // determine if the user's cards are all the same (eliminates possibility of three of a kind)
        else if(isSameCard(hand)){
            System.out.println("You got a three of a kind! Add more to this condition!");
            return 4;
        }

        // determine if the user has cards that are in order by value (eliminates possibly of straight)
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
    private static boolean isSameSuit(int[][] usersCards){
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
    private static boolean isSameCard(int[][] usersCards){
        int card = usersCards[1][0];
        for(int i = 1; i < 3; i++){
            if(usersCards[1][i] != card){
                return false;
            }
        }
        return true;
    }

    // Function to determine if the cards in the hand are in order. Return true if yes, false if no.
    private static boolean isInOrder(int[][] usersCards){
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
    private static boolean hasPair(int[][] usersCards){
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
    private static int highestValueCard(int[][] usersCards){
        int[] cardValues = new int[3];
        for(int i = 0; i < 3; i++){
            cardValues[i] = usersCards[1][i];
        }

        return Arrays.stream(cardValues).max().getAsInt();
    }

    // Function to compare the dealer's hand and the player's hand
    public void compareHands(int [][] playersHand, int [][] dealersHand, int playersHighestCard, int dealersHighestCard) {
        int playersHandRanking = calculateHighestRank(playersHand, playersHighestCard);
        int dealersHandRanking = calculateHighestRank(dealersHand, dealersHighestCard);

        if(playersHandRanking < dealersHandRanking){
            System.out.println("Sorry! You Lost!");
            // calculate money lost based on the player's bets
        }
        else if(playersHandRanking > dealersHandRanking){
            System.out.println("Congrats, you win!");
        }
        else{
            System.out.println("Sorry, you tied. No money lost tho!");
        }
    }

    // Funtion to load the deck for calculations
    // Hearts = index 0, Spades = index 1, Clubs = index 2, Diamonds = index 3
    // Aces are considered as card 1
    private void loadDeck(int[][] deck){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 14; j++){
                this.deck[i][j] = j+1;
            }
        }
    }

    public int determineWinningsCurrent(){
        //
        return 0;
    }

    private int updateUserCards(){
        return 0;
    }
    private int updateDealersCards(){
        return 0;
    }

    public static int evalHand(ArrayList<Card> hand) {
        return 0;
    }

    public static int evalPPWinnings(ArrayList<Card> hand, int bet) {
        return 0;
    }
}
