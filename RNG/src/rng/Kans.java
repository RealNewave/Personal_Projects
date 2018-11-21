/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rng;

import java.util.ArrayList;

/**
 *
 * @author Hans
 */
public class Kans {

    private final int winner = (int) (Math.random() * 100) + 1;
    private double itemKans = 10;

    public boolean succes() {
        return succesGetallen(itemKans).stream().anyMatch((succesGetal) -> (succesGetal == winner));
    }

    private ArrayList<Integer> succesGetallen(double kans) {
        ArrayList<Integer> getallen = new ArrayList<>();

        int random;
        for (int i = 0; i <= kans; i++) {
            random = (int) ((Math.random() * 100) + 1);
            if (!getallen.isEmpty()) {
                for (int getal : getallen) {
                    while (getal == random) {
                        random = (int) ((Math.random() * 100) + 1);
//                        System.out.println(getal+" ander getal "+random);
                        if (getal != random) {
                            break;
                        }
                    }
                }
            }
            getallen.add(random);
        }
        return getallen;
    }
}
