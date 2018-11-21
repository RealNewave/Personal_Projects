/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tobiasles;

import java.util.Scanner;



/**
 *
 * @author Hans
 */
public class LesClass {
    
    Scanner sc = new Scanner(System.in);
    String test = "test";
    public void test(){
          System.out.println("Hello World");
          System.out.println(test);
          System.out.println("Geef je naam in: ");
          String invoer = sc.next();
          System.out.println("Hallo " + invoer);
    }
}
