/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;

/**
 *
 * @author Hans
 */
public class Opdracht7 {

    public static void main(String[] args) {

        int getal = 1, priemGetal = 1;
        boolean isPriem = false;
        while (priemGetal < 10001) {
            getal += 2;
            for (int i = 2; i < getal; i++) {
                if (getal % i == 0) {
                    isPriem = false;
                    break;
                } else {
                    isPriem = true;
                }
            }
            if (isPriem) {
                priemGetal++;

            }

        }
        System.out.println("Priem: " + getal + "Priemgetal: " + priemGetal);
    }
}
