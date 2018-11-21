/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Poker;

/**
 *
 * @author Hans
 */
public class Controller {
    
    Game game = Game.getInstance();
    public void setEvent(String event){
        game.setEvent(event);
        
    }
    
}
