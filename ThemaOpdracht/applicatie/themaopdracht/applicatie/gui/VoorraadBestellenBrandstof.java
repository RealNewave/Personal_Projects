package themaopdracht.applicatie.gui;

import themaopdracht.applicatie.controller.ProductBestelControler;
import themaopdracht.domein.voorraadbeheer.Brandstof;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VoorraadBestellenBrandstof extends BorderPane {
	private VBox invulLijst, tekstLijst;
	private Button annuleren, bestelKnop;
	private HBox buttons;
	private TextField aantalLiterstf;
	
	public VoorraadBestellenBrandstof(KnoppenMenu km, Stage owner, Brandstof brandstof) {
		ProductBestelControler controler = new ProductBestelControler(km);
		Label productNaamLab = new Label("Artikel:");
		Label productNummerLab = new Label("Artikelnummer:");
		Label brandstoftype = new Label("Brandstoftype");
		Label aantalOpVoorraad = new Label("Liters op voorraad");
		Label aantalLiters = new Label("Aantal liters:");
		Label tsic = new Label("TSIC:");
		
		tekstLijst = new VBox();
		tekstLijst.setSpacing(20);
		tekstLijst.setPadding(new Insets(20));
		tekstLijst.setAlignment(Pos.CENTER_LEFT);
		tekstLijst.getChildren().addAll(productNaamLab,productNummerLab,tsic, brandstoftype, aantalOpVoorraad, aantalLiters);
		
		setLeft(tekstLijst);
		
		
		Label brandstofNaam = new Label(brandstof.getNaam());
		brandstofNaam.setPrefWidth(150);
		Label artikelnummerLab = new Label("" + brandstof.getProductNr());
		artikelnummerLab.setPrefWidth(150);
		Label tsicLab = new Label(brandstof.getTSIC());
		tsicLab.setPrefWidth(150);
		Label brandstoftypeLab = new Label(""+brandstof.getType());
		brandstoftypeLab.setPrefWidth(150);
		Label aantalOpVoorraadLab = new Label("" + brandstof.getAantalLiters());
		aantalOpVoorraadLab.setPrefWidth(150);
		aantalLiterstf = new TextField();
		
		invulLijst = new VBox();
		invulLijst.setSpacing(20);
		invulLijst.setPadding(new Insets(20));
		invulLijst.setAlignment(Pos.CENTER_RIGHT);
		invulLijst.getChildren().addAll(brandstofNaam,artikelnummerLab, tsicLab, brandstoftypeLab, aantalOpVoorraadLab, aantalLiterstf);
		
		setRight(invulLijst);
		
		annuleren = new Button("Annuleren");
		annuleren.setOnAction(event -> {
			km.setDefaultScene("Bestelling afgebroken");
		});
		bestelKnop = new Button("Toevoegen");
		bestelKnop.setOnAction(event -> {
			try{
				int aantal = Integer.parseInt(aantalLiterstf.getText());
				if (aantal > 0) {
					controler.bestelBrandstof(owner, brandstof, aantal);
				} else {
					Alert al = new Alert(owner, "Vul een geldig aantal in.");
					al.showAndWait();
				}
			} catch (NumberFormatException e){
				Alert al = new Alert(owner, "Vul een aantal in.");
				al.showAndWait();
			}
		});
		
		buttons = new HBox();
		buttons.setSpacing(10);
		buttons.setPadding(new Insets(10));
		buttons.setAlignment(Pos.BOTTOM_RIGHT);
		buttons.getChildren().addAll(annuleren, bestelKnop);
		setBottom(buttons);

	}

}
