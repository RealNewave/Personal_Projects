package themaopdracht.applicatie.gui;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class Alert extends Stage {
	public Alert(Stage owner, String bericht) {
		super(StageStyle.UTILITY);
		initOwner(owner);
		initModality(Modality.WINDOW_MODAL);
		this.setResizable(false);
		this.setTitle(bericht);
		Label melding = new Label(bericht);
		melding.setAlignment(Pos.BASELINE_CENTER);
		melding.setPrefWidth(250);
		Button ok = new Button("Ok");
		ok.setPrefWidth(75);
		ok.setOnAction(e -> this.hide());
		VBox controlBox = new VBox(10);
		controlBox.setAlignment(Pos.CENTER);
		controlBox.getChildren().addAll(melding, ok);
		controlBox.setPadding(new Insets(15));
		Scene scene = new Scene(controlBox);
		this.setScene(scene);
	}
}