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
public class Opdracht5 {

    public static void main(String[] args) {

        int i = 1;
        while (true) {
            boolean result = false;

            for (int j = 1; j < 21; j++) {
                if (i % j == 0) {
                    result = true;
                } else {
                    result = false;
                    break;
                }

            }
            if (result) {
                System.out.println(i);
            }
            i++;

        }

    }
}

