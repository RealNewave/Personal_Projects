package themaopdracht.applicatie.controller;

import themaopdracht.applicatie.gui.KnoppenMenu;
import themaopdracht.domein.exceptions.ExistingInstanceException;
import themaopdracht.domein.klantenbinding.Klantbeheer;

public class KlantToevoegenContr {
	private Klantbeheer klantbeheer;
	private KnoppenMenu km;

	public KlantToevoegenContr(KnoppenMenu km, Klantbeheer kb) {
		this.km = km;
		this.klantbeheer = kb;
	}

	public void klantToevoegen(String nm, String adr, String eAdr) {
		try {
			klantbeheer.voegKlantToe(nm, adr, eAdr);
			km.setDefaultScene("Klant succesvol toegevoegd");
		} catch (ExistingInstanceException e) {
			e.printStackTrace();
		}
	}
}