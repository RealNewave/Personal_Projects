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
public class HasQuarter {
    GumballMachine gumballmachine;
    NoQuarter noquarter;
    GumballSold gumballsold;
    
    public void Main(GumballMachine gumballmachine){
        this.gumballmachine = gumballmachine;
    }
    
    public void setStates(NoQuarter noquarter, GumballSold gumballsold){
        this.noquarter = noquarter;
        this.gumballsold = gumballsold;
    }
    public void ejectQuarter(){
        System.out.println("HASQUARTER:ejecting quarter");
        this.noquarter.insertQuarter();
    }
    public void turnCrank(){
        System.out.println("HASQUARTER:dispensing");
        this.gumballsold.dispense();
    }
}
