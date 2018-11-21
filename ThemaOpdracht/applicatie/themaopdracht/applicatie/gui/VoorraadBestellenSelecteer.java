package themaopdracht.applicatie.gui;

import themaopdracht.applicatie.controller.VoorraadBestellenSelecteerContr;
import themaopdracht.domein.voorraadbeheer.Brandstof;
import themaopdracht.domein.voorraadbeheer.Product;
import themaopdracht.domein.voorraadbeheer.Voorraad;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VoorraadBestellenSelecteer extends BorderPane {
	private HBox buttons;
	private CheckBox cb1, cb2;
	private ComboBox<Product> productcb;
	private ComboBox<Brandstof> brandstofcb;
	private Button annuleren, verder;
	private VoorraadBestellenSelecteerContr controller;
	
	public VoorraadBestellenSelecteer(KnoppenMenu km, Stage owner, Voorraad v) {
		controller = new VoorraadBestellenSelecteerContr(v);
		
		cb1 = new CheckBox();
		cb1.setSelected(true);
		cb1.setOnAction(event ->{
			if(cb1.isSelected()){
				productcb.setDisable(false);
				cb2.setSelected(false);
				brandstofcb.setDisable(true);
			} else if(!cb1.isSelected()){
				productcb.setDisable(true);
				if(!cb2.isSelected()){
					brandstofcb.setDisable(true);
				}
			}
		});
		Label product = new Label("product:");
		productcb = new ComboBox<Product>();
		productcb.setPrefWidth(150);
		productcb.setItems(controller.vulComboBoxMetProducten());
		productcb.setValue(controller.getEersteProduct());
		
		cb2 = new CheckBox();
		cb2.setOnAction(event ->{
			if(cb2.isSelected()){
				brandstofcb.setDisable(false);
				productcb.setDisable(true);
				cb1.setSelected(false);
			} else if(!cb2.isSelected()){
				brandstofcb.setDisable(true);
				if(!cb1.isSelected()){
					productcb.setDisable(true);
				}
			}
		});
		Label brandstof = new Label("brandstof:");
		brandstofcb = new ComboBox<Brandstof>();
		brandstofcb.setPrefWidth(150);
		brandstofcb.setItems(controller.vulComboBoxMetBrandstof());
		brandstofcb.setValue(controller.getEersteBrandstof());
		brandstofcb.setDisable(true);

		
		HBox hb = new HBox();
		hb.setSpacing(60);
		hb.setPadding(new Insets(20));
		hb.setAlignment(Pos.CENTER_LEFT);
		hb.getChildren().addAll(cb1, product, productcb);
		
		HBox hb2 = new HBox();
		hb2.setSpacing(55);
		hb2.setPadding(new Insets(20));
		hb2.setAlignment(Pos.CENTER_LEFT);
		hb2.getChildren().addAll(cb2, brandstof, brandstofcb);
		
		VBox content = new VBox();
		content.getChildren().addAll(hb, hb2);
		this.setLeft(content);
		
		annuleren = new Button("Annuleren");
		annuleren.setOnAction(event -> {
			km.setDefaultScene("Bestelling afgebroken");
		});
		verder = new Button("Verder");
		verder.setOnAction(event -> {
			if(cb1.isSelected()){
				Product p = productcb.getValue();
				km.openVoorraadBestellen(p);
			} else if(cb2.isSelected()){
				Brandstof b = brandstofcb.getValue();
				km.openVoorraadBestellenBrandstof(b);
			} else{
				Alert al = new Alert(owner, "Selecteer een product");
				al.showAndWait();
			}
			
		});
		
		buttons = new HBox();
		buttons.setSpacing(10);
		buttons.setPadding(new Insets(10));
		buttons.setAlignment(Pos.BOTTOM_RIGHT);
		buttons.getChildren().addAll(annuleren, verder);
		
		this.setBottom(buttons);
	}
}
