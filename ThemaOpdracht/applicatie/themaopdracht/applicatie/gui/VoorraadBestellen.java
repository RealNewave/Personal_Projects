package themaopdracht.applicatie.gui;

import themaopdracht.applicatie.controller.ProductBestelControler;
import themaopdracht.domein.voorraadbeheer.Product;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VoorraadBestellen extends BorderPane {
	private VBox invulLijst, tekstLijst;
	private Button annuleren, controleerAantallen;
	private HBox buttons;
	private TextField aantalStukstf;

	public VoorraadBestellen(KnoppenMenu km, Stage owner, Product product) {
		ProductBestelControler controler = new ProductBestelControler(km);
		Label productLabel = new Label("Product:");
		Label artikelnummer = new Label("productnummer:");
		Label aantalAanwezig = new Label("aantal op voorraad");
		Label aantalStuks = new Label("aantal stuks:");

		tekstLijst = new VBox();
		tekstLijst.setSpacing(20);
		tekstLijst.setPadding(new Insets(20));
		tekstLijst.setAlignment(Pos.CENTER_LEFT);
		tekstLijst.getChildren().addAll(productLabel, artikelnummer, aantalAanwezig,
				aantalStuks);

		this.setLeft(tekstLijst);

		Label productNaamLabel = new Label(product.getNaam());
		productNaamLabel.setPrefWidth(150);
		Label productnummerLabel = new Label("" + product.getProductNr());
		productnummerLabel.setPrefWidth(150);
		Label productaantalAanwezig = new Label("" + product.getAantal());
		productaantalAanwezig.setPrefWidth(150);
		aantalStukstf = new TextField();

		invulLijst = new VBox();
		invulLijst.setSpacing(20);
		invulLijst.setPadding(new Insets(20));
		invulLijst.setAlignment(Pos.CENTER_RIGHT);
		invulLijst.getChildren().addAll(productNaamLabel, productnummerLabel, productaantalAanwezig,
				aantalStukstf);

		this.setRight(invulLijst);

		annuleren = new Button("Annuleren");
		annuleren.setOnAction(event -> {
			km.setDefaultScene("Bestelling afgebroken");
		});
		controleerAantallen = new Button("Bestellen");
		controleerAantallen.setOnAction(event -> {
			try{
				int aantal = Integer.parseInt(aantalStukstf.getText());
				if (aantal > 0) {
					controler.bestelProduct(owner, product, aantal);
				} else {
					Alert al = new Alert(owner, "Vul een geldig aantal in.");
					al.showAndWait();
				}
			}catch(NumberFormatException e){
				Alert al = new Alert(owner, "Vul een aantal in.");
				al.showAndWait();
			}
		});

		buttons = new HBox();
		buttons.setSpacing(10);
		buttons.setPadding(new Insets(10));
		buttons.setAlignment(Pos.BOTTOM_RIGHT);
		buttons.getChildren().addAll(annuleren, controleerAantallen);

		this.setBottom(buttons);
	}
}
