/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drankautmomaat;

import java.util.ArrayList;

/**
 *
 * @author Hans
 */
public abstract class Dranken {

    public abstract String getNaam();

    public abstract void setNaam();

    public abstract ArrayList<Recept> getRecept();
}
