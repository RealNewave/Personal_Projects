package themaopdracht.applicatie.controller;

import javafx.stage.Stage;
import themaopdracht.applicatie.gui.Alert;
import themaopdracht.applicatie.gui.KnoppenMenu;
import themaopdracht.domein.voorraadbeheer.Brandstof;
import themaopdracht.domein.voorraadbeheer.Leverancier;
import themaopdracht.domein.voorraadbeheer.Product;

public class ProductBestelControler {
	private KnoppenMenu km;
	
	public ProductBestelControler(KnoppenMenu km){
		this.km = km;
	}
	
	public void bestelProduct(Stage owner, Product p, int aantal){
		Leverancier l = null;
		try{
			l = p.getLeverancier();
			String emailAdres = l.getEmailAdres();
			//verzendEmail();
			Alert al = new Alert(owner, aantal + "x " + p.getNaam() + " besteld.");
			al.showAndWait();
			km.setDefaultScene("Bestelling succesvol");
		}catch(NullPointerException e){
			Alert al = new Alert(owner, "Leverancier onbekend.");
			al.showAndWait();
		}
	}
	
	public void bestelBrandstof(Stage owner, Brandstof b, int aantal){
		Leverancier l = null;
		try{
			l = b.getLeverancier();
			String emailAdres = l.getEmailAdres();
			//verzendEmail();
			Alert al = new Alert(owner, aantal + " liter " + b.getNaam() + " besteld.");
			al.showAndWait();
			km.setDefaultScene("Bestelling succesvol");
		}catch(NullPointerException e){
			Alert al = new Alert(owner, "Leverancier onbekend.");
			al.showAndWait();
		}
	}
}
