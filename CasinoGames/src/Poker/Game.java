package Poker;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hans
 */
public class Game {

    private ArrayList<String> cards;
    private Table table = new Table();
    private String event;
    private int callValue = 10;
    private int raiseValue = 20;
    private static Game instance = null;
    
    private Game() {
    }

    public static Game getInstance() {
        if(instance == null){
            instance = new Game();
        }
        return instance;
    }

    public synchronized final boolean runGame(ArrayList<Player> players, Deck deck, HandRanking ranking) {
        boolean gameStatus = false;

        Runnable waitForInput = () -> {

                initializeDeck(deck);
                dealHand(players);
                showAllHands(players);
                System.out.println("first");
                makeAMove(players);
                dealFlop();
                System.out.println("second");
                makeAMove(players);
                dealTurn();
                System.out.println("third");
                makeAMove(players);
                dealRiver();
                showCardsOnTable();
                getHandRanking(players, ranking);

        };
        Thread thread = new Thread(waitForInput);
        thread.setDaemon(true);
        thread.start();

        return gameStatus;
    }

    private boolean initializeDeck(Deck deck) {
        cards = deck.getCards();
        return true;
    }

    private String getRandomCard() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, cards.size());
        String card = cards.get(randomNum);
        cards.remove(randomNum);
        return card;
    }

    private void dealHand(ArrayList<Player> players) {
        for (Player player : players) {
            player.hand[0] = getRandomCard();
            player.hand[1] = getRandomCard();
        }
    }

    private void makeAMove(ArrayList<Player> players) {
        for (Player player : players) {
            if (player.isFolded) {
                continue;
            }
            while(event == null){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            switch (event) {
                case "call":
                    player.chipAmount -= callValue;
                    table.chipsInPot += callValue;
                    break;
                case "raise":
                    //int raiseValue = selectRaiseValue;
                    player.chipAmount -= raiseValue;
                    table.chipsInPot += raiseValue;
                    break;
                case "fold":
                    player.isFolded = true;
                    break;
            }
            event = null;
        }
        
    }

    private void dealFlop() {
        for (int i = 0; i < 3; i++) {
            table.cards.add(getRandomCard());
        }
    }

    private void dealTurn() {
        table.cards.add(getRandomCard());
    }

    private void dealRiver() {
        table.cards.add(getRandomCard());
    }

    private void showCardsOnTable() {
        table.cards.forEach((card) -> {
            System.out.println("Table: " + card);
        });
    }

    private void showAllHands(ArrayList<Player> players) {

        players.forEach((player) -> {
            for (String card : player.hand) {
                System.out.println(player.nickName + ": " + card);
            }
        });
    }

    private void getHandRanking(ArrayList<Player> players, HandRanking ranking) {
        players.forEach((player) -> {
            String result = ranking.evaluate(player.hand, table.cards);
            System.out.println(player.nickName + " ranking: " + result);

        });
    }

    public void setEvent(String event) {
        this.event = event;
    }

}
