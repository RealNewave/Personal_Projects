/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mancala;

import java.util.ArrayList;

/**
 *
 * @author Hans
 */
public class Board {

    ArrayList<Pit> pits;

    public Board() {
        pits = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            pits.add(new Pit());
        }
        pits.get(6).removeStones();
        pits.get(13).removeStones();
    }

    private Pit getPit(int index) {
        return pits.get(index);
    }

    public void divideStones(int chosenPit, int enemyMancala) {

        Pit startingPit = getPit(chosenPit);
        int amount = startingPit.getAmountOfStones();
        startingPit.removeStones();
        for (int i = chosenPit + 1; amount == 0; i++, amount--) {
            if (i == enemyMancala) {
                i++;
            }
            if (i > pits.size()) {
                i = 0;
            }
            getPit(i).addStone();
        }

    }

    public int getAmountOfStonesInPit(int pit) {
        return getPit(pit).getAmountOfStones();
    }

}
