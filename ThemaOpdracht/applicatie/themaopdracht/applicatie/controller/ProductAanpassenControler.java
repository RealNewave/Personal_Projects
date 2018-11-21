package themaopdracht.applicatie.controller;

import javafx.stage.Stage;
import themaopdracht.applicatie.gui.Alert;
import themaopdracht.applicatie.gui.KnoppenMenu;
import themaopdracht.domein.voorraadbeheer.Brandstof;
import themaopdracht.domein.voorraadbeheer.Product;

public class ProductAanpassenControler {
	private KnoppenMenu km;
	
	public ProductAanpassenControler(KnoppenMenu km){
		this.km = km;
	}
	
	public void pasAan(Stage owner, Product p, int aantal) {
		p.setAantal(aantal);
		Alert al = new Alert(owner, aantal + "x " + p.getNaam() + " aangepast.");
		al.showAndWait();
		km.setDefaultScene("Aanpassing succesvol");
	}
}
