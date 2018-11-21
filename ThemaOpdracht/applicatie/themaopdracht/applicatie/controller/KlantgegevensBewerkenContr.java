package themaopdracht.applicatie.controller;

import themaopdracht.applicatie.gui.KlantgegevensBewerken;
import themaopdracht.applicatie.gui.KnoppenMenu;
import themaopdracht.domein.klantenbinding.Klant;
import themaopdracht.domein.klantenbinding.Klantbeheer;

public class KlantgegevensBewerkenContr {
	private Klantbeheer kb;
	private String naam,adres,email;
	
	public KlantgegevensBewerkenContr() {
	}
	
	public void klantOpvragen(String nm, Klantbeheer k, KnoppenMenu km, KlantgegevensBewerken klantBewerken) {
		naam = k.zoekKlant(nm).getNaam();
		adres = k.zoekKlant(nm).getAdres();
		email = k.zoekKlant(nm).getEmailAdres();
		klantBewerken.setVakken(naam,adres,email);
	}
	
	public void bewerkGegevens(String nm, String adres, String email, Klantbeheer k) {
		k.zoekKlant(nm).setNaam(nm);
		k.zoekKlant(nm).setAdres(adres);
		k.zoekKlant(nm).setEmailAdres(email);
	}
}
