/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GumballMachine;

public class GumballSold {
    SoldOut soldout;
    NoQuarter noquarter;
    int numGumballs = 10;
    
    public void Main(){
        
    }
    
    public void setGumballs(){
        
    }
    
    public void setStates(NoQuarter noquarter, SoldOut soldout){
        this.noquarter = noquarter;
        this.soldout = soldout;
    }
    public void dispense(){
        numGumballs -=1;
        if(numGumballs > 0){
            System.out.println("GUMBALLSOLD:gumballs now: "+numGumballs);
            System.out.println("GUMBALLSOLD:inserting quarter");
            this.noquarter.insertQuarter();
        }
        else{
            System.out.println("HASQUARTER:filling gumballs");
            this.soldout.fill();
            numGumballs = 10;
            noquarter.insertQuarter();
        }
    }
}
