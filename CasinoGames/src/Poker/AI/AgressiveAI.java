/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Poker.AI;

import Poker.HandRanking;

/**
 *
 * @author Hans
 */
public class AgressiveAI {

    HandRanking handRanking = new HandRanking();

    private String getCurrentRanking() {
        
        return "High Card";
    }
    private int getWinChance(){
        return 0;
    }
    private int getCardNeededChance(){
        return 0;
    }
}
