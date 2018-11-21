/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rng;

/**
 *
 * @author Hans
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Kans kans = new Kans();
        int aantalKeer = 0;
        while (true) {
            aantalKeer++;
            if (!kans.succes()) {
                System.out.println("Aantal keer: " + aantalKeer);
            } else {
                break;
            }
            
        }
        System.out.println("Upgrade gelukt in " + aantalKeer);

    }
}
