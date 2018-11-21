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
public class Controller {

    private Kookboek gerechten = new Gerecht();
    private ArrayList<Gerecht> gerechtenLijst = gerechten.getGerechten();

    public void alleGerechten() {

        gerechtenLijst.stream().forEach((g) -> {
            System.out.println(g.getNaamRecept());
        });
    }

    public boolean zoekReceptOpNaam(String naamRecept) {
        for (Gerecht g : gerechtenLijst) {
            if (g.getNaamRecept().equals(naamRecept)) {
                System.out.println(
                        g.getNaamRecept() + "\n"
                        + g.getType() + "\n"
                        + ingredientenPrint(g) + "\n"
                        + g.getReceptBeschrijving()
                );
            }
            return true;
        }
        System.out.println("Gerecht niet gevonden.");
        return false;
    }

    private String ingredientenPrint(Gerecht g) {
        
        String x = "";
        for(String s :g.getIngredienten()){
            x += s;
            
        }
        
        return x;
    }

    public void zoekReceptOpSoort(String soort) {
        gerechtenLijst.stream().filter((g) -> ((g.getType().toString()).equals(soort))).forEach((g) -> {
            System.out.println(g.getNaamRecept());
        });

    }

    public void voegGerechtToe(String naamRecept, Enum type, ArrayList<String> ingredienten, String beschrijving) {
        Gerecht nieuwGerecht = new Gerecht();
        nieuwGerecht.setNaamRecept(naamRecept);
        nieuwGerecht.setType(type);
        nieuwGerecht.setIngredienten(ingredienten);
        nieuwGerecht.setReceptBeschrijving(beschrijving);

        gerechtenLijst.add(nieuwGerecht);
        System.out.println("Gerecht " + nieuwGerecht.getNaamRecept() + " is toegevoegd!");
    }

}
