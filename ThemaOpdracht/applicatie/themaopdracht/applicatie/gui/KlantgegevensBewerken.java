package themaopdracht.applicatie.gui;

import themaopdracht.applicatie.controller.KlantgegevensBewerkenContr;
import themaopdracht.domein.klantenbinding.Klantbeheer;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class KlantgegevensBewerken extends BorderPane {
	private TextField klantaccounttf, adrestf, emailtf, datumLaatsteBezoektf;
	private ComboBox factuurNummercb, betalingsStatuscb;
	private RadioButton contant, pin;
	private Button bewerkenB, annulerenB;
	private ToggleGroup betaalmethodeGroep;
	private VBox tekst, invulvakjes;
	private HBox knoppen, radiobuttons;
	private KlantgegevensBewerkenContr deController;
	private Klantbeheer kb;
	
	public KlantgegevensBewerken(KnoppenMenu km) {
		Label klantaccount = new Label("Klantaccount:");
		Label adres = new Label("Adres:");
		Label email = new Label("E-mail");
		Label betaalmethode = new Label("Betaalmethode:");
		Label datumLaatsteBezoek = new Label("Datum laatste bezoek:");
		Label factuurNummer = new Label("Factuurnummer:");
		Label betalingsStatus = new Label("Betalingsstatus:");
		
		tekst = new VBox();
		tekst.setSpacing(15);
		tekst.setPrefWidth(150);
		tekst.setPadding(new Insets(10));
		tekst.setAlignment(Pos.CENTER_LEFT);
		tekst.getChildren().addAll(klantaccount,adres,email,betaalmethode,datumLaatsteBezoek,factuurNummer,betalingsStatus);
		
		this.setLeft(tekst);
		
		klantaccounttf = new TextField();
		adrestf = new TextField();
		emailtf = new TextField();
		betaalmethodeGroep = new ToggleGroup();
		contant = new RadioButton("Contant");
		contant.setToggleGroup(betaalmethodeGroep);
		pin = new RadioButton("Pin/Creditcard");
		pin.setToggleGroup(betaalmethodeGroep);
		radiobuttons = new HBox();
		radiobuttons.setSpacing(40);
		radiobuttons.getChildren().addAll(contant,pin);
		datumLaatsteBezoektf = new TextField();
		factuurNummercb = new ComboBox();
		factuurNummercb.setPrefWidth(250);
		betalingsStatuscb = new ComboBox();
		betalingsStatuscb.setPrefWidth(250);
		
		invulvakjes = new VBox();
		invulvakjes.setPrefWidth(250);
		invulvakjes.setSpacing(8);
		invulvakjes.setPadding(new Insets(10));
		invulvakjes.setAlignment(Pos.CENTER_LEFT);
		invulvakjes.getChildren().addAll(klantaccounttf,adrestf,emailtf,radiobuttons,datumLaatsteBezoektf,factuurNummercb,betalingsStatuscb);
		
		this.setRight(invulvakjes);
		
		
		bewerkenB = new Button("Bewerken");
		bewerkenB.setOnAction(event -> {
			deController.bewerkGegevens(klantaccounttf.getText(),adrestf.getText(),emailtf.getText(),kb);
		});
		
		annulerenB = new Button("Annuleren");
		annulerenB.setOnAction(event -> {
			km.setDefaultScene("Succesvol geannuleerd");
		});
		
		knoppen = new HBox();
		knoppen.setPadding(new Insets(10));
		knoppen.setAlignment(Pos.BOTTOM_RIGHT);
		knoppen.setSpacing(10);
		knoppen.getChildren().addAll(annulerenB, bewerkenB);
		
		this.setBottom(knoppen);
	}
	
	public void setVakken(String nm, String adr, String eAdr) {
		klantaccounttf.setText(nm);
		adrestf.setText(adr);
		emailtf.setText(eAdr);
	}
}