/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mancala;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

/**
 *
 * @author Hans
 */
public class GameController {

    private final Board board;
    private final Player player1, player2;

    public GameController() throws IOException {
        board = new Board();
        int[] player1Array = new int[]{0, 1, 2, 3, 4, 5, 6};
        int[] player2Array = new int[]{7, 8, 9, 10, 11, 12, 13};
        player1 = new Player("Player1", true, 0, player1Array);
        player2 = new Player("Player2", false, 0, player2Array);
        gameLoop();
    }

    private void gameLoop() throws IOException{
        
        while (true) {
            Player player = whichPlayerTurn();

            System.out.println(player.getPlayerName() + " choose a pit: ");

            int[] pitsOwned = player.getPitsOwned();

            for (int i = 0, menuIndex = 1; i < pitsOwned.length; i++, menuIndex++) {
                System.out.println(menuIndex + ". " + board.getAmountOfStonesInPit(pitsOwned[i]) + " stones");
            }

            int pitIndex = waitForPlayerInput();
            
            board.divideStones(pitIndex, getEnemyMancala(player));
            switchTurn();
        }
    }
    
    public Board getBoard() {
        return board;
    }

    private int getEnemyMancala(Player currentPlayer) {

        if (currentPlayer.getPlayerName().equals("player1")) {
            return 6;
        }
        return 13;
    }
    
    private Player whichPlayerTurn() {
        if (player1.isPlayerTurn()) {
            return player1;
        }
        return player2;
    }

    private int waitForPlayerInput() throws IOException {
        int input = 0;
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            try {

                input = Integer.parseInt(br.readLine());

                if (input > 0 && input <= 6) {
                    break;
                } else {
                    throw new InputMismatchException("Invaldid input");

                }

            } catch (InputMismatchException ime) {
                System.out.println("Invalid input");
            }
        }
        return input - 1;
    }

    

    

    private void switchTurn() {
        player1.setPlayerTurn(!player1.isPlayerTurn());
        player2.setPlayerTurn(!player2.isPlayerTurn());
    }

}
