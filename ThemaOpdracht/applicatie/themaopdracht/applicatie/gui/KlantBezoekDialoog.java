package themaopdracht.applicatie.gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class KlantBezoekDialoog extends Stage{
	private int aantal = 0;
	private TextField tf;
	
	public KlantBezoekDialoog(Stage owner){
		super(StageStyle.UTILITY);
		initModality(Modality.WINDOW_MODAL);
		this.setResizable(false);
		this.setTitle("Geef een aantal maanden op");
		
		setHeight(150);
		setWidth(350);
		
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(15));
		
		VBox center = new VBox();
		HBox inCenter = new HBox();
		HBox bottom = new HBox();
		
		Label melding = new Label("Vul een periode in");
		Label vulMaandenIn = new Label("aantal maanden afwezig:");
		tf = new TextField();
		
		Button annuleren = new Button("annuleren");
		annuleren.setOnAction(event -> hide());
		Button ok = new Button("OK");
		ok.setOnAction(event -> setAantal());
		
		bottom.getChildren().addAll(annuleren, ok);
		inCenter.getChildren().addAll(vulMaandenIn, tf);
		center.getChildren().addAll(melding, inCenter);
		
		root.setCenter(center);
		root.setBottom(bottom);
		
		Scene scene = new Scene(root);
		this.setScene(scene);
	}
	
	public void setAantal(){
		try{
			aantal = Integer.parseInt(tf.getText());
			hide();
		}catch(NumberFormatException nfe){}
	}
	
	public int getAantal(){
		return aantal;
	}

}
