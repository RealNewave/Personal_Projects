/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fishingpond;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

/**
 *
 * @author Hans
 */
public class FishingPond extends Application {

    private double ovalX = 250, ovalY = 450, x = 1, multiplier = 0.01;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Fishing Pond");
        Group root = new Group();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        Canvas canvas = new Canvas(500, 500);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        new AnimationTimer() {
            @Override
            public void handle(long now) {

                gc.clearRect(0, 0, 500, 500);
                gc.fillOval(ovalX, ovalY, 10, 10);
                canvas.setOnMouseMoved((event) -> {
                    if(event.getX() >= ovalX - 5
                            && event.getX() <= ovalX + 5){
                        multiplier+=0.08;
//                        System.out.println("touched");
                    }
                });
                ovalX = 100 * Math.sin(x) + 100;
//                multiplier += 0.01;
                x += multiplier;
                multiplier = 0.01;
                
            }

        }.start();

        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
