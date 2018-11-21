package whatyouseeiswhatyouget;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Hans
 */
public class WhatYouSeeIsWhatYouGet extends Application {

    private final List<Objects> objects = new ArrayList<>();

    private boolean inObject = false;
    private int selectedObjectIndex;
    private static double canvasWidth = 1768, canvasHeight = 992;
    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("WYSIWYG");
        primaryStage.setResizable(true);
        Group root = new Group();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        root.getChildren().add(canvas);

        
        GraphicsContext gc = canvas.getGraphicsContext2D();
       
        Button rectangle = new Button("Rectangle");
        rectangle.setLayoutX(canvasWidth - 50);
        rectangle.setLayoutY(0);
        
        Button oval = new Button("Oval");
        oval.setLayoutX(canvasWidth - 50);
        oval.setLayoutY(25);

        Button clearScreen = new Button("Clear Screen");
        clearScreen.setLayoutX(canvasWidth - 50);
        clearScreen.setLayoutY(50);

        TextField length = new TextField();
        length.setLayoutX(canvasWidth - 50);
        length.setLayoutY(75);

        TextField width = new TextField();
        width.setLayoutX(canvasWidth - 50);
        width.setLayoutY(100);

        root.getChildren().addAll(rectangle, oval, clearScreen, length, width);

        clearScreen.addEventHandler(ActionEvent.ANY, e -> {
            objects.clear();
        });

        rectangle.addEventHandler(ActionEvent.ANY, e -> {
            Objects rect = new Objects(300, 300, 50, 50, "Rectangle", false);
            objects.add(rect);
        });
        oval.addEventHandler(ActionEvent.ANY, e -> {
            Objects ovl = new Objects(200, 200, 50, 50, "Oval", false);
            objects.add(ovl);
        });
        width.addEventHandler(ActionEvent.ANY, e -> {
            for (Objects obj : objects) {
                if (obj.selected) {
                    obj.sizeX = Double.parseDouble(width.getText());
                    break;
                }
            }
        });
        length.addEventHandler(ActionEvent.ANY, e -> {
            for (Objects obj : objects) {
                if (obj.selected) {
                    obj.sizeY = Double.parseDouble(length.getText());
                    break;
                }
            }
        });

        canvas.addEventHandler(MouseEvent.ANY, (MouseEvent e) -> {
            if (e.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
                selectedObjectIndex = 0;
                for (Objects obj : objects) {
                    obj.selected = isMouseInObject(e, obj);
                    if (obj.selected) {
                        length.setText("" + obj.sizeY);
                        width.setText("" + obj.sizeX);

                    }

                    selectedObjectIndex++;
                }
            }

            if (e.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
                selectedObjectIndex = 0;
                for (Objects obj : objects) {
                    if (isMouseInObject(e, obj)) {
                        inObject = true;
                        break;
                    }
                    selectedObjectIndex++;
                }

            }

            if (inObject) {
                if (e.getEventType().equals(MouseEvent.MOUSE_DRAGGED)) {
                    Objects obj = objects.get(selectedObjectIndex);
                    obj.objectX = e.getX() - obj.sizeX / 2;
                    obj.objectY = e.getY() - obj.sizeY / 2;
                }
                if (e.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
                    inObject = false;
                    selectedObjectIndex = 0;
                }
            }
        });
        new AnimationTimer() {
            @Override
            public void handle(long now) {

                gc.clearRect(0, 0, canvasWidth, canvasHeight);
                drawObjects(objects.size(), gc);

            }

        }
                .start();
        primaryStage.hide();
        primaryStage.show();

    }

    private static boolean isMouseInObject(MouseEvent e, Objects obj) {
        return e.getX() >= obj.objectX && e.getX() <= obj.objectX + obj.sizeX
                && e.getY() >= obj.objectY && e.getY() <= obj.objectY + obj.sizeY;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void drawObjects(int drawTimes, GraphicsContext gc) {

        if (drawTimes > 0) {
            for (int i = 0; i < drawTimes; i++) {
                Objects obj = objects.get(i);

                switch (obj.type) {
                    case "Rectangle":
                        drawRectangle(gc, obj);
                        break;
                    case "Oval":
                        drawOval(gc, obj);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void drawOval(GraphicsContext gc, Objects obj) {
        gc.setFill(Color.BLUE);
        gc.fillOval(obj.objectX, obj.objectY, obj.sizeX, obj.sizeY);
        if (obj.selected) {
            gc.setStroke(Color.LIMEGREEN);
            gc.setLineWidth(5);
            gc.strokeOval(obj.objectX, obj.objectY, obj.sizeX + 1, obj.sizeY + 1);
        }
    }

    private void drawRectangle(GraphicsContext gc, Objects obj) {
        gc.setFill(Color.RED);

        gc.fillRect(obj.objectX, obj.objectY, obj.sizeX, obj.sizeY);
        if (obj.selected) {
            gc.setStroke(Color.LIMEGREEN);
            gc.setLineWidth(5);
            gc.strokeRect(obj.objectX, obj.objectY, obj.sizeX + 1, obj.sizeY + 1);
        }
    }

//    private Color getColor(MouseEvent e, Canvas canvas) {
//                WritableImage writableImage = new WritableImage(500,500);
//                canvas.snapshot(null, writableImage);
//                return writableImage.getPixelReader().getColor((int)e.getX(), (int)e.getY());
//            }
    public class Objects {

        public double objectX, objectY, sizeX, sizeY;
        public String type;
        public boolean selected;

        public Objects(double objectX, double objectY, double sizeX, double sizeY, String type, boolean selected) {
            this.objectX = objectX;
            this.objectY = objectY;
            this.sizeX = sizeX;
            this.sizeY = sizeY;
            this.type = type;
            this.selected = selected;
        }

    }

}
