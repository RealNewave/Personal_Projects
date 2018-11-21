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
public class NoQuarter {
    GumballMachine gumballmachine;
    HasQuarter hasquarter;
    
    public void Main(GumballMachine gumballmachine){
        this.gumballmachine = gumballmachine;
    }
    
    public void setStates(HasQuarter hasquarter){
        this.hasquarter = hasquarter;
    }
    public void insertQuarter(){
        System.out.println("NOQUARTER:turning crank");
        hasquarter.turnCrank();
    }
}
