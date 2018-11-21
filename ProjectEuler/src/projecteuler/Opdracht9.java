/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;

import java.util.Random;

/**
 *
 * @author Hans
 */
public class Opdracht9 {

    public static void main(String[] args) {

        double a = 1, b = 1, c = 1;
        Random r1 = new Random();
        Random r2 = new Random();


        while (true) {

            a = r1.nextInt(1000) + 1;
            b = r2.nextInt(1000) + 1;


            if (a < b) {
                a = Math.pow(a, 2);
                b = Math.pow(b, 2);
                c = a + b;

                if (b < c) {
                    a =  Math.sqrt(a);
                    b =  Math.sqrt(b);
                    c =  Math.sqrt(c);
                    if (a + b + c == 1000 && a< b && b < c) {
                        break;
                    }
                }
            }
        }
        System.out.println("outside loop: a: " + a + " b: " + b + " c: " + c);
        System.out.println("Answer: " + (int)(a * b * c));
    }
}
