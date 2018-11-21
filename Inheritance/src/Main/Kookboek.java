/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Gerechten.Gerecht;

import java.util.ArrayList;

/**
 *
 * @author Hans
 */
public abstract class Kookboek {

    private ArrayList<Gerecht> gerechten = new ArrayList<>();

    public abstract String getNaamRecept();
    public abstract void setNaamRecept(String naamRecept);
    public abstract ArrayList<String> getIngredienten();
    public abstract void setIngredienten(ArrayList<String> ingredienten);
    public abstract String getReceptBeschrijving();
    public abstract void setReceptBeschrijving(String receptBeschrijving);
    public abstract Enum getType();
    public abstract void setType(Enum type);
    
    
    public ArrayList<Gerecht> getGerechten() {
        return gerechten;
    }

    public void setGerechten(ArrayList<Gerecht> gerechten) {
        this.gerechten = gerechten;
    }

}
