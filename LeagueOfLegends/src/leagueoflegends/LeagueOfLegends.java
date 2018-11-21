/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leagueoflegends;

import leagueoflegends.champions.Trundle;
import leagueoflegends.champions.TrundleBuilder;

/**
 *
 * @author Hans
 */
public class LeagueOfLegends {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Trundle trundle = new TrundleBuilder().setHealth(200).setMana(100).createTrundle();
        System.out.println(trundle.getHealth());
        
        
    }
    
}
