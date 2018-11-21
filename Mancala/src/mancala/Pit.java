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
public class Pit {

    private final ArrayList<Stone> stones = new ArrayList<>();

    public Pit() {
        for (int i = 0; i < 4; i++) {
            stones.add(new Stone());
        }
    }

    public void addStone() {
        stones.add(new Stone());
    }
    
    public void removeStones(){
        for (int i = stones.size() - 1; i >= 0; i--) {
            stones.remove(0);
        }
    }
    public int getAmountOfStones(){
        return stones.size();
    }

}
