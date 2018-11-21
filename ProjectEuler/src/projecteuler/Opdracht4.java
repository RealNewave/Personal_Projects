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
public class Opdracht4 {

    

    public static void main(String[] args){
        int number = 0;
        int solution = 0;
        for (int i = 100; i < 999; i++) {
            for (int j = 100; j < 999; j++) {
                number = i * j;
                if(reverse(number) == number && number > solution){
                    
                    solution = number;
                }
            }
        }

        System.out.println(solution);
    }
     static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }

        return rev;
    }

   
}
