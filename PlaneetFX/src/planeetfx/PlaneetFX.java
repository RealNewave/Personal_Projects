/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planeetfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author Hans
 */
public class PlaneetFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        Circle c = new Circle(3);
        Circle c2 = new Circle(3);

        StackPane root = new StackPane();
        root.getChildren().addAll(c, c2);
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Test");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void run() {
        Thread move = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    
                }
            }

        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
