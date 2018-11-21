/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package follow;

import java.util.ArrayList;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Hans
 */
public class Follow extends Application {

    Random random = new Random();
    ArrayList<Chaser> chasers = new ArrayList<>();
    int amount = 1;

    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();
        pane.setMinSize(900, 900);
        Label enemyAmount = new Label();
        enemyAmount.setLayoutX(30);
        enemyAmount.setLayoutY(20);
        enemyAmount.setText("Enemies: " + amount);

        pane.getChildren().addAll(enemyAmount);

        Scene scene = new Scene(pane, 1000, 1000);

        primaryStage.setTitle("Follow");
        primaryStage.setScene(scene);
        primaryStage.show();

        new AnimationTimer() {
            double currentMouseX;
            double currentMouseY;
            int i = 0;

            @Override
            public void handle(long now) {
                if (i % 100 == 0) {
                    Pane chaser = makeChaser();
                    chaser.setLayoutX(random.nextInt(900)+1);
                    chaser.setLayoutY(random.nextInt(900)+1);
                    pane.getChildren().add(chaser);
                    amount++;
                    enemyAmount.setText("Enemies: " + amount);
                }
                scene.setOnMouseMoved((event) -> {
                    currentMouseX = event.getX();
                    currentMouseY = event.getY();
                });
                chasers.forEach((c) -> {

                    double chaserSpeed = c.getCurrentSpeedY();
                    Pane soloPane = c.getPane();
                    Bounds bounds = soloPane.getLayoutBounds();
                    Point2D currentLocationChaser = soloPane.localToScene(bounds.getMinX(), bounds.getMinY());
//                    currentLocationChaser.getX();
//                    currentLocationChaser.getY();
                    double chaserSpeedX = c.getCurrentSpeedX();
                    double chaserSpeedY = c.getCurrentSpeedY();

                    if (currentLocationChaser.getX() < currentMouseX) {

                        if (chaserSpeedX < c.getMaxSpeed()) {
                            c.setCurrentSpeedX(chaserSpeedX += 0.2);
                        }
                        soloPane.setTranslateX(soloPane.getTranslateX() + chaserSpeedX);
                    }
                    if (currentLocationChaser.getX() > currentMouseX) {
                        if (chaserSpeedX > (-1 * c.getMaxSpeed())) {
                            c.setCurrentSpeedX(chaserSpeedX -= 0.2);
                        }
                        soloPane.setTranslateX(soloPane.getTranslateX() + chaserSpeedX);
                    }
                    if (currentLocationChaser.getY() < currentMouseY) {
                        if (chaserSpeedY < c.getMaxSpeed()) {
                            c.setCurrentSpeedY(chaserSpeedY += 0.2);
                        }
                        soloPane.setTranslateY(soloPane.getTranslateY() + chaserSpeedY);
                    }
                    if (currentLocationChaser.getY() > currentMouseY) {
                        if (chaserSpeedY > (-1 * c.getMaxSpeed())) {
                            c.setCurrentSpeedY(chaserSpeedY -= 0.2);
                        }
                        soloPane.setTranslateY(soloPane.getTranslateY() + chaserSpeedY);
                    }

                });
                i++;
            }

        }.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private Pane makeChaser() {
        int speed = random.nextInt(10) + 3;
        int size = random.nextInt(50) + 10;
        Pane pane = new Pane();
        pane.setLayoutX(random.nextInt(50));
        pane.setLayoutY(random.nextInt(50));
        Rectangle chaser = new Rectangle(size, size);
        pane.getChildren().add(chaser);
        Chaser enemy = new Chaser(size, speed, pane);
        chasers.add(enemy);
        return pane;
    }

    private double slowDown(double chaserSpeed) {
        return chaserSpeed;
    }

    private double speedUp(double chaserSpeed) {
        return chaserSpeed;
    }
}
