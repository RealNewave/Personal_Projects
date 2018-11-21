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
public class Opdracht6 {

    public static void main(String[] args) {
        
    
        int sum = 0;
        int sumSum = 0;
        
        for (int i = 1; i <= 100; i++) {
            sum += Math.pow(i, 2);
        }
        
        for(int i = 1; i <= 100;i++){
            sumSum += i;
           
        }
        
        int squareSum = (int) Math.pow(sumSum, 2);
        System.out.println(squareSum - sum);
    }
}
