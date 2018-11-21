/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gerechten;

import Main.Kookboek;
import java.util.ArrayList;

/**
 *
 * @author Hans
 */
public class Gerecht extends Kookboek {

    private String naamRecept;
    private ArrayList<String> ingredienten;
    private String receptBeschrijving;
    private Enum type;

    /**
     * @return the naamRecept
     */
    @Override
    public String getNaamRecept() {
        return naamRecept;
    }

    /**
     * @param naamRecept the naamRecept to set
     */
    @Override
    public void setNaamRecept(String naamRecept) {
        this.naamRecept = naamRecept;
    }

    /**
     * @return the ingredienten
     */
    @Override
    public ArrayList<String> getIngredienten() {
        return ingredienten;
    }

    /**
     * @param ingredienten the ingredienten to set
     */
    @Override
    public void setIngredienten(ArrayList<String> ingredienten) {
        this.ingredienten = ingredienten;
    }

    /**
     * @return the receptBeschrijving
     */
    @Override
    public String getReceptBeschrijving() {
        return receptBeschrijving;
    }

    /**
     * @param receptBeschrijving the receptBeschrijving to set
     */
    @Override
    public void setReceptBeschrijving(String receptBeschrijving) {
        this.receptBeschrijving = receptBeschrijving;
    }

    @Override
    public Enum getType() {
        return type;
    }

    @Override
    public void setType(Enum type) {
        this.type = type;
    }

}
