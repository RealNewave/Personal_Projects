package Poker;


import java.util.ArrayList;

/**
 *
 * @author Hans
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Player> players = new ArrayList<>();
        char name = '1';
        for (int i = 0; i < 9; i++) {
            Player p = new Player();
            p.nickName = "player " + name;
            name ++;
            p.chipAmount = 500;
            p.isFolded = false;
            players.add(p);
        }
        Game game = new Game();
        Deck deck = new Deck();
        HandRanking ranking = new HandRanking();
        game.runGame(players, deck, ranking);

    }

}
