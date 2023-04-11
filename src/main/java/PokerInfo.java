import java.io.Serializable;
import java.util.ArrayList;

public class PokerInfo implements Serializable {
    private int player_id;
    private int gamesPlay;
    private int numwin;
    private ArrayList<Integer> playersCards;
    private int playerAnte;
    private int playerPair;
    private int playerWage;
    private ArrayList<Integer> dealersCards;





    public PokerInfo(int p) {
        this.dealersCards = new ArrayList<>();
        this.playerAnte = 0;
        this.player_id = 1;
        this.playerPair = 0;
        this.playerWage = 0;
        this.numwin = 0;
        this.gamesPlay = 0;
        this.playersCards = new ArrayList<>();
    }
    private int calculateHighestRank(){
        return 0;
    }
    private int determineWinningsCurrent(){
        return 0;
    }
    private int updateUserCards(){
        return 0;
    }
    private int updateDealersCards(){
        return 0;
    }


}
