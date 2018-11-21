package themaopdracht.applicatie.gui;

import themaopdracht.applicatie.controller.KlantKiezenContr;
import themaopdracht.domein.klantenbinding.Klant;
import themaopdracht.domein.klantenbinding.Klantbeheer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class KlantKiezen extends BorderPane {
	private HBox knoppenBewerken;
	private Button annuleren, klantBewerken;
	private ListView<Klant> klanten;
	private ObservableList<Klant> alleKlanten = FXCollections.observableArrayList();
	private KlantKiezenContr controllerKlasse;
	
	public KlantKiezen(KnoppenMenu km, Stage owner, Klantbeheer kb) {
		controllerKlasse = new KlantKiezenContr(kb);
		
		alleKlanten = controllerKlasse.klantenLijst();

		annuleren = new Button("Annuleren");
		annuleren.setOnAction(event -> {
			km.setDefaultScene("Succesvol geannuleerd");
		});
		
		Button klantBezoek = new Button("Selectie");
		klantBezoek.setOnAction(event ->{
			KlantBezoekDialoog kbd = new KlantBezoekDialoog(owner);
			kbd.showAndWait();
			if(kbd.getAantal() != 0){
				klanten.setItems(controllerKlasse.klantBezoeken(kbd.getAantal()));
			}
		});
		
		Button onderhoud = new Button("Onderhoud");
		onderhoud.setOnAction(event -> {
			klanten.setItems(controllerKlasse.klantOnderhoud());
		});

		klantBewerken = new Button("Bewerk klant");
		klantBewerken.setOnAction(event -> {
			Klant k = klanten.getSelectionModel().getSelectedItem();
			try{
				String nm = k.getNaam();
				km.openKlantGegevensBewerken(nm, kb);
			} catch(NullPointerException npe){
				Alert al = new Alert(owner, "Selecteer een klant");
				al.showAndWait();
			}
		});


		klanten = new ListView<Klant>();
		klanten.setItems(alleKlanten);
		klanten.setPrefHeight(400);
		klanten.setPrefWidth(350);

		knoppenBewerken = new HBox();
		knoppenBewerken.setPadding(new Insets(10));
		knoppenBewerken.setAlignment(Pos.BOTTOM_RIGHT);
		knoppenBewerken.setSpacing(10);
		knoppenBewerken.getChildren().addAll(annuleren, klantBezoek, onderhoud, klantBewerken);
		
		ContextMenu contextMenu = new ContextMenu();
		MenuItem miVerzendBezoek = new MenuItem("Verstuur bezoek");
		miVerzendBezoek.setOnAction(e -> controllerKlasse.verzendBezoekBericht(klanten.getSelectionModel().getSelectedItem(), owner));
		MenuItem miVerzendControle = new MenuItem("Verstuur controle");
		miVerzendControle.setOnAction(e -> controllerKlasse.verzendControleBericht(klanten.getSelectionModel().getSelectedItem(), owner));
		contextMenu.getItems().addAll(miVerzendBezoek, miVerzendControle);
		klanten.setContextMenu(contextMenu);
		
		
		this.setBottom(knoppenBewerken);
		this.setTop(klanten);
	}
}
