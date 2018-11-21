/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mancala;

/**
 *
 * @author Hans
 */
public class Player {

    private String playerName;
    private boolean playerTurn;
    private int playerScore;
    private int[] pitsOwned;
    private int mancala;

    public Player(String playerName, boolean playerTurn, int playerScore, int[] pitsOwned) {
        this.playerName = playerName;
        this.playerTurn = playerTurn;
        this.playerScore = playerScore;
        this.pitsOwned = pitsOwned;
        this.mancala = pitsOwned[pitsOwned.length - 1];
    }

    public String getPlayerName() {
        return playerName;
    }

    public boolean isPlayerTurn() {
        return playerTurn;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getMancala() {
        return mancala;
    }

    public int[] getPitsOwned() {
        return pitsOwned;
    }

    public void setPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

}
