package themaopdracht.applicatie.controller;

import javafx.stage.Stage;
import themaopdracht.applicatie.gui.Alert;
import themaopdracht.applicatie.gui.KnoppenMenu;
import themaopdracht.domein.voorraadbeheer.Brandstof;
import themaopdracht.domein.voorraadbeheer.Product;

public class BrandstofAanpassenControler {
	private KnoppenMenu km;
	
	public BrandstofAanpassenControler(KnoppenMenu km){
		this.km = km;
	}
	
	public void pasBrandstofAan(Stage owner, Brandstof b, int aantal) {
		b.setAantalLiters(aantal);
		Alert al = new Alert(owner, aantal + "x " + b.getNaam() + " aangepast.");
		al.showAndWait();
		km.setDefaultScene("Aanpassing succesvol");
	}
}