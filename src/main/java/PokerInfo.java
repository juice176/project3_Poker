import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class PokerInfo implements Serializable {
    //the players hand
    public Card cards[];
    private LinkedList<Card> deck;
    private Random shuffler;
    private boolean fold;
    private int player_id;

    private int gamesPlay;
    private int numwin;
    private ArrayList<Integer> playersCards;
    private int playerAnte;
    private int playerPair;
    private int playerWage;
    private ArrayList<Integer> dealersCards;






    public PokerInfo(int p) {
        cards = new Card[5];
        this.dealersCards = new ArrayList<>();
        this.playerAnte = 0;
        this.player_id = 1;
        this.playerPair = 0;
        this.playerWage = 0;
        this.numwin = 0;
        this.gamesPlay = 0;
        this.playersCards = new ArrayList<>();
        this.fold = false;
    }

    private int calculateHighestRank(){
        //straight flush
        //three of a kind
        //straight
        //flush
        //pair
        //high card

        return 0;
    }

    private int determineWinningsCurrent(){
        //
        return 0;
    }
    private int updateUserCards(){
        //card[3]
        //shuffle the Cards
        //
        return 0;
    }
    private int updateDealersCards(){
        //card[3]
        //shuffle the Cards
        return 0;
    }
    public static int evalHand(ArrayList<Card> hand) {
        return 0;
    }

    public static int evalPPWinnings(ArrayList<Card> hand, int bet) {
        return 0;
    }

    public static int compareHands(ArrayList<Card> dealer,
                                   ArrayList<Card> player) {
       // dealersCards = new ArrayList<Integer>();


        return 0;
    }


}
