package themaopdracht.applicatie.gui;

import themaopdracht.applicatie.controller.KlantToevoegenContr;
import themaopdracht.domein.klantenbinding.Klantbeheer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class KlantToevoegen extends BorderPane {
	private TextField klantaccounttf, adrestf, emailtf, datumLaatsteBezoektf;
	private RadioButton contant, pin;
	private HBox radioButtons, buttons;
	private VBox labels, waardeInvoeren;
	private KlantToevoegenContr controllerKlasse;

	public KlantToevoegen(KnoppenMenu km, Klantbeheer kb) {
		controllerKlasse = new KlantToevoegenContr(km, kb);

		Label melding = new Label("");
		melding.setAlignment(Pos.CENTER);
		melding.setPadding(new Insets(20));
		this.setTop(melding);

		Label klantaccount = new Label("Klantnaam:");
		Label adres = new Label("Adres:");
		Label email = new Label("E-mail:");
		Label betaalMethode = new Label("Betaalmethode:");
		Label datumLaatsteBezoek = new Label("Datum laatste bezoek:");

		labels = new VBox();
		labels.setSpacing(15);
		labels.setPrefWidth(150);
		labels.setPadding(new Insets(10));
		labels.setAlignment(Pos.CENTER_LEFT);
		labels.getChildren().addAll(klantaccount, adres, email, betaalMethode,
				datumLaatsteBezoek);

		this.setLeft(labels);

		klantaccounttf = new TextField();
		adrestf = new TextField();
		emailtf = new TextField();
		ToggleGroup betaalmethodeGroep = new ToggleGroup();
		contant = new RadioButton("Contant");
		contant.setToggleGroup(betaalmethodeGroep);
		pin = new RadioButton("Pin/Creditcard");
		pin.setToggleGroup(betaalmethodeGroep);
		radioButtons = new HBox();
		radioButtons.setSpacing(40);
		radioButtons.getChildren().addAll(contant, pin);
		datumLaatsteBezoektf = new TextField();

		waardeInvoeren = new VBox();
		waardeInvoeren.setPrefWidth(250);
		waardeInvoeren.setSpacing(8);
		waardeInvoeren.setPadding(new Insets(10));
		waardeInvoeren.setAlignment(Pos.CENTER_LEFT);
		waardeInvoeren.getChildren().addAll(klantaccounttf, adrestf, emailtf,
				radioButtons, datumLaatsteBezoektf);

		this.setRight(waardeInvoeren);

		Button annulerenB = new Button("Annuleren");
		annulerenB.setOnAction(event -> {
			km.setDefaultScene("Succesvol geannuleerd");
		});

		Button toevoegenB = new Button("Toevoegen");
		toevoegenB.setOnAction(event -> {
			controllerKlasse.klantToevoegen(getKlantNaam(), getKlantAdres(),
					getKlantEmail());
			
		});

		buttons = new HBox();
		buttons.setSpacing(10);
		buttons.setPadding(new Insets(10));
		buttons.setAlignment(Pos.BOTTOM_RIGHT);
		buttons.getChildren().addAll(annulerenB, toevoegenB);

		this.setBottom(buttons);
	}

	public String getKlantNaam() {
		return klantaccounttf.getText();
	}

	public String getKlantAdres() {
		return adrestf.getText();
	}

	public String getKlantEmail() {
		return emailtf.getText();
	}
}