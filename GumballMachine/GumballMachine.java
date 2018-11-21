/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GumballMachine;

/**
 *
 * @author patrick
 */
public class GumballMachine {
    int numGumballs = 10;
    /*NoQuarter noquarter;
    HasQuarter hasquarter;
    GumballSold gumballsold;
    SoldOut soldout;*/

    public static void main(String[] args) {
        System.out.println("Start");
        NoQuarter noquarter = new NoQuarter();
        HasQuarter hasquarter = new HasQuarter();
        GumballSold gumballsold = new GumballSold();
        SoldOut soldout = new SoldOut();
        //give states todo
        noquarter.setStates(hasquarter);
        hasquarter.setStates(noquarter, gumballsold);
        gumballsold.setStates(noquarter, soldout);
        soldout.setStates(noquarter);
        noquarter.insertQuarter();
    }
}