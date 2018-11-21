package themaopdracht.applicatie.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import themaopdracht.applicatie.gui.Alert;
import themaopdracht.applicatie.gui.KlantKiezen;
import themaopdracht.domein.klantenbinding.Klant;
import themaopdracht.domein.klantenbinding.Klantbeheer;

public class KlantKiezenContr{

	private static Klantbeheer beheer;
	private KlantKiezen kk;
	
	public KlantKiezenContr(Klantbeheer kb) {
		this.beheer = kb;
	}
	
	public ObservableList<Klant> klantenLijst() {
		ObservableList<Klant> alleKlanten = FXCollections.observableArrayList();
		for (Klant k : beheer.getAlleKlanten()) {
			alleKlanten.add(k);
		}
		return alleKlanten;
	}
	
	public ObservableList<Klant> klantBezoeken(int aantal) {
		ObservableList<Klant> alleKlanten = FXCollections.observableArrayList();
		for (Klant k : beheer.getKlantenMaandenAfwezig(aantal)) {
			alleKlanten.add(k);
		}
		return alleKlanten;
	}
	
	public ObservableList<Klant> klantOnderhoud(){
		ObservableList<Klant> alleKlanten = FXCollections.observableArrayList();
		for(Klant k : beheer.getKlantenToeAanOnderhoud()){
			alleKlanten.add(k);
		}
		return alleKlanten;
	}
	
	public void verzendBezoekBericht(Klant k, Stage owner){
		String naam = k.getNaam();
		String emailAdres = k.getEmailAdres();
		//verstuurEmail();
		Alert al = new Alert(owner, "Bericht is verzonden.");
		al.showAndWait();
	}
	
	public void verzendControleBericht(Klant k, Stage owner){
		String naam = k.getNaam();
		String emailAdres = k.getEmailAdres();
		//verstuurEmail();
		Alert al = new Alert(owner, "Bericht is verzonden.");
		al.showAndWait();
	}
}