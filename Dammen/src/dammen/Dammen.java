/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dammen;

import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Hans
 */
public class Dammen extends Application {
    static StackPane[] currentBoard = null;

    @Override
    public void start(Stage primaryStage) {
        MakeBoard makeBoard = new MakeBoard();
        Pane boardPane = new Pane();
        boardPane.setMinSize(400.0, 400.0);
        boardPane.setLayoutX(200.0);
        boardPane.setLayoutY(0.0);
        currentBoard = makeBoard.makeBoard(boardPane.getMinWidth(), boardPane.getMinHeight());
        boardPane.getChildren().addAll(Arrays.asList(currentBoard));
        
        Scene window = new Scene(boardPane, 800, 600);

        primaryStage.setTitle("Dammen");
        primaryStage.setScene(window);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
