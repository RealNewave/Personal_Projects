package themaopdracht.applicatie.controller;

import themaopdracht.domein.klantenbinding.Klantbeheer;
import themaopdracht.domein.voorraadbeheer.Voorraad;

public class SuperController {
	/**
	 * @author Rogier Pijpers
	 * 
	 * De supercontroller bevat de objecten klantbeheer en voorraad.
	 * Aan alle andere controllers worden deze object meegegeven.
	 * Op deze manier wordt in elk onderdeel van de applicatie hetzelfde object bewerkt
	 */
	private Klantbeheer kb;
	private Voorraad v;
	
	public SuperController(){
		kb = new Klantbeheer();
		v = new Voorraad();
	}
	
	public Klantbeheer getKlantbeheer(){
		return kb;
	}
	
	public Voorraad getVoorraad(){
		return v;
	}
}
