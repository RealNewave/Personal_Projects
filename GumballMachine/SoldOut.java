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
public class SoldOut {
    GumballMachine gumballmachine;
    NoQuarter noquarter;
    
    public void Main(GumballMachine gumballmachine){
        this.gumballmachine = gumballmachine;
    }
    
    public void setStates(NoQuarter noquarter){
        this.noquarter = noquarter;
    }
    public void fill(){
        
    }
}
