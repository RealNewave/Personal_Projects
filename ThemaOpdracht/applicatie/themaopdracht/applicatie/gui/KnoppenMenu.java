package themaopdracht.applicatie.gui;

import themaopdracht.applicatie.controller.KlantgegevensBewerkenContr;
import themaopdracht.applicatie.controller.SuperController;
import themaopdracht.domein.klantenbinding.Klantbeheer;
import themaopdracht.domein.voorraadbeheer.Brandstof;
import themaopdracht.domein.voorraadbeheer.Product;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class KnoppenMenu extends Application {
	private SuperController superControl;
	
	private Button klantToevoegen, klantenlijst, voorraadBestellenButton, voorraadAanpassenButton; //anders
	private KlantgegevensBewerken klantBewerken;
	private VBox knoppenpaneel;
	private BorderPane hoofdmenubp, menubp;
	private Stage stage;
	
	private KlantKiezen klantKiezen;
	private KlantToevoegen klantToevoegenInterface;
	private VoorraadBestellenSelecteer voorraadbestellenSelecteer;
	private VoorraadAanpassenSelecteer voorraadAanpassenSelecteer;		//nieuw
	private VoorraadBestellen voorraadBestellen;
	private VoorraadBestellenBrandstof voorraadBestellenBrandstof;
	private KlantgegevensBewerkenContr controllerBewerken;
	private VoorraadAanpassen voorraadAanpassen; //nieuw
	private VoorraadAanpassenBrandstof voorraadAanpassenBrandstof; //nieuw
	
	public void start(Stage primaryStage) {
		superControl = new SuperController();
		
		stage = primaryStage;
		hoofdmenubp = new BorderPane();
		
		Label melding = new Label("");
		
		klantToevoegen = new Button("Klant toevoegen");
		klantToevoegen.setPrefWidth(200);
		klantToevoegen.setOnAction(event -> {
			openKlantToevoegen();
		});
		
		klantenlijst = new Button("Klantenlijst");
		klantenlijst.setPrefWidth(200);
		klantenlijst.setOnAction(event -> {
			openKlantKiezen();
		});
		
		voorraadBestellenButton = new Button("Voorraad bestellen");
		voorraadBestellenButton.setPrefWidth(200);
		voorraadBestellenButton.setOnAction(event -> {
			openVoorraadBestellenSelecteer();
		});
		
		voorraadAanpassenButton = new Button("Voorraad aanpassen");		//nieuw
		voorraadAanpassenButton.setPrefWidth(200);
		voorraadAanpassenButton.setOnAction(event -> {
			openVoorraadAanpassenSelecteer();
		});
		
		
		knoppenpaneel = new VBox();
		knoppenpaneel.setAlignment(Pos.CENTER);
		knoppenpaneel.setSpacing(20);
		knoppenpaneel.getChildren().addAll(klantToevoegen,klantenlijst,voorraadBestellenButton,voorraadAanpassenButton); //anders
		
		hoofdmenubp.setCenter(knoppenpaneel);
		
		Scene hoofdScene = new Scene(hoofdmenubp, 300, 250);
		stage.setTitle("Hoofdmenu");
		stage.setResizable(false);
		stage.setScene(hoofdScene);
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void openKlantToevoegen() {
		klantToevoegenInterface = new KlantToevoegen(this, superControl.getKlantbeheer());
		Scene sc = new Scene(klantToevoegenInterface);
		stage.setTitle("Klant toevoegen");
		stage.setScene(sc);
	}
	
	public void openKlantKiezen() {
		klantKiezen = new KlantKiezen(this, stage, superControl.getKlantbeheer());
		Scene sc = new Scene(klantKiezen);
		stage.setTitle("Klantgegevens bewerken");
		stage.setScene(sc);
	}
	
	public void openVoorraadBestellenSelecteer() {
		voorraadbestellenSelecteer = new VoorraadBestellenSelecteer(this, stage, superControl.getVoorraad());
		Scene sc = new Scene(voorraadbestellenSelecteer);
		stage.setTitle("Voorraad bestellen");
		stage.setScene(sc);
	}
	
	public void openVoorraadAanpassenSelecteer() {			//nieuw
		voorraadAanpassenSelecteer = new VoorraadAanpassenSelecteer(this, stage, superControl.getVoorraad());
		Scene sc = new Scene(voorraadAanpassenSelecteer);
		stage.setTitle("Voorraad aanpassen");
		stage.setScene(sc);
	}
	
	public void openVoorraadAanpassen(Product p){			//nieuw
		voorraadAanpassen = new VoorraadAanpassen(this, stage, p);
		Scene sc = new Scene(voorraadAanpassen);
		stage.setTitle("Product aanpassen");
		stage.setScene(sc);
	}
	
	public void openVoorraadAanpassenBrandstof(Brandstof b) { //nieuw
		voorraadAanpassenBrandstof = new VoorraadAanpassenBrandstof(this, stage, b);
		Scene sc = new Scene(voorraadAanpassenBrandstof);
		stage.setTitle("Brandstof aanpassen");
		stage.setScene(sc);
	}
	
	public void openVoorraadBestellen(Product p){
		voorraadBestellen = new VoorraadBestellen(this, stage, p);
		Scene sc = new Scene(voorraadBestellen);
		stage.setTitle("Product bestellen");
		stage.setScene(sc);
	}
	
	public void openVoorraadBestellenBrandstof(Brandstof b){
		voorraadBestellenBrandstof = new VoorraadBestellenBrandstof(this, stage, b);
		Scene sc = new Scene(voorraadBestellenBrandstof);
		stage.setTitle("Brandstof bestellen");
		stage.setScene(sc);
	}
	
	public void openKlantGegevensBewerken(String nm, Klantbeheer kb) {
		controllerBewerken = new KlantgegevensBewerkenContr();
		klantBewerken = new KlantgegevensBewerken(this);
		Scene sc = new Scene(klantBewerken);
		stage.setTitle("Klant bewerken");
		stage.setScene(sc);
		controllerBewerken.klantOpvragen(nm, kb, this, klantBewerken);
	}
	
	public void setDefaultScene(String s) {
		methode(s);
		Scene hoofdScene = new Scene(menubp, 300, 250);
		stage.setScene(hoofdScene);
		stage.setTitle("Hoofdmenu");
	}
	
	public void methode(String s) {
		menubp = new BorderPane();
		
		Label melding = new Label(s);
		
		klantToevoegen = new Button("Klant toevoegen");
		klantToevoegen.setPrefWidth(200);
		klantToevoegen.setOnAction(event -> {
			openKlantToevoegen();
		});
		
		klantenlijst = new Button("Klantenlijst");
		klantenlijst.setPrefWidth(200);
		klantenlijst.setOnAction(event -> {
			openKlantKiezen();
		});
		
		voorraadBestellenButton = new Button("Voorraad bestellen");
		voorraadBestellenButton.setPrefWidth(200);
		voorraadBestellenButton.setOnAction(event -> {
			openVoorraadBestellenSelecteer();
		});
		
		voorraadAanpassenButton = new Button("Voorraad aanpassen");		//nieuw
		voorraadAanpassenButton.setPrefWidth(200);
		voorraadAanpassenButton.setOnAction(event -> {
			openVoorraadAanpassenSelecteer();
		});
		
		knoppenpaneel = new VBox();
		knoppenpaneel.setAlignment(Pos.CENTER);
		knoppenpaneel.setSpacing(20);
		knoppenpaneel.getChildren().addAll(melding,klantToevoegen,klantenlijst,voorraadBestellenButton,voorraadAanpassenButton); //anders
		
		menubp.setCenter(knoppenpaneel);
	}
}
