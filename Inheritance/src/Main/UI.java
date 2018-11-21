/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hans
 */
public class UI {

    private Controller methods = new Controller();
    private String naamRecept = null, beschrijving = null;
    private Enum type = null;
    private ArrayList<String> ingredienten = null;
    private int keuze = 0;

    public UI() {
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        System.out.println(
                "Maak een keuze:" + "\n"
                + "1.Zoek recept" + "\n"
                + "2.Voeg recept toe" + "\n"
                + "3.Exit");

        keuze = Integer.parseInt(sc.nextLine());
        if (keuze > 0 && keuze <= 3) {
            switch (keuze) {
                case 1:
                    System.out.println(
                            "Maak een keuze:" + "\n"
                            + "1.Kies recept uit lijst" + "\n"
                            + "2.Zoek recept op naam" + "\n"
                            + "3.Zoek recept op soort" + "\n"
                            + "4.Ga terug");
                    switch (sc.nextLine()) {
                        case "1":
                            methods.alleGerechten();
                            break;
                        case "2":
                            System.out.println("Wat is de naam van het recept?");
                            methods.zoekReceptOpNaam(sc.nextLine());
                            break;
                        case "3":
                            System.out.println("Is het een Vis-, Vlees- of Kip-gerecht? :");
                            methods.zoekReceptOpSoort(sc.nextLine());
                            break;
                        case "4":
                            break;
                        default:
                            break;
                    }

                    break;
                case 2:
                    System.out.println("Type de naam van het recept:");
                    naamRecept = sc.nextLine();

                    System.out.println("Is het een Vis-(1), Vlees-(2) of Kip-gerecht(3)? :");

                    switch (sc.nextLine()) {
                        case "1":
                            type = Type.Vis;
                            break;
                        case "2":
                            type = Type.Vlees;
                            break;
                        case "3":
                            type = Type.Kip;
                            break;
                        default:
                            break;
                    }

                    System.out.println("Wat zijn de ingredienten?(Vul 'einde' in om te eindigen):");
                    ingredienten = new ArrayList<>();
                    while (sc.hasNext()) {
                        if (!sc.next().equals("einde")) {
                            ingredienten.add(sc.nextLine());
                        } else {
                            break;
                        }
                    }
                    System.out.println("Wat is de beschrijving van het recept?(Vul 'einde' in om te eindigen):");
                    while (sc.hasNext()) {
                        if (!sc.next().equals("einde")) {
                            beschrijving = sc.nextLine();
                        } else {
                            break;
                        }
                    }
                    methods.voegGerechtToe(naamRecept, type, ingredienten, beschrijving);
                    break;
                case 3:
                    System.exit(0);
                default:
                    break;

            }
        }

    }
}
