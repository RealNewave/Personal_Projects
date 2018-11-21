/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dammen;

import static dammen.eventHandler.action;
import static dammen.eventHandler.color;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Hans
 */
public class MakeBoard {


    private Rectangle[] makeBoardTiles(double sceneWidth, double sceneHeight) {
        Rectangle[] tiles = new Rectangle[100];
        boolean colorSwitch = false;
        for (int i = 0; i < 100; i++) {
            Rectangle boardTile = new Rectangle();
            boardTile.setWidth(sceneWidth / 10.0);
            boardTile.setHeight(sceneHeight / 10.0);
            boardTile.setFill(Color.BROWN);

            if (colorSwitch) {
                boardTile.setFill(Color.YELLOW);
            }
            colorSwitch ^= true;
            tiles[i] = boardTile;
//            System.out.println("makeBoardTiles: " + tiles[i].getWidth());
            if ((i + 1) % 10 == 0) {
                colorSwitch ^= true;
            }
        }
        return tiles;
    }

    private Label[] setupBoardContents() {
        Label[] contents = new Label[100];

        boolean placeX = true;
        for (int i = 0; i < 100; i++) {
            Label boardLabel = makeLabel(null, null);

            if (i >= 0 && i < 40 && placeX) {
                boardLabel.setText("x");
                boardLabel.setTextFill(Color.BLACK);

            }
            if (i >= 60 && placeX) {
                boardLabel.setText("x");
                boardLabel.setTextFill(Color.WHITE);

            }

            placeX ^= true;
            if ((i + 1) % 10 == 0) {
                placeX ^= true;
            }

            contents[i] = boardLabel;
//            System.out.println(i + " : " + squares[i].getTextFill());

        }
        return contents;
    }

    public static Label makeLabel(String text, Color color) {
        Label boardLabel = new Label();
        boardLabel.setText(" ");
        if (text != null) {
            boardLabel.setText(text);
        }
        boardLabel.setTextFill(Color.GRAY);
        if (color != null) {
            boardLabel.setTextFill(color);
        }
        return boardLabel;
    }

    public StackPane[] makeBoard(double sceneWidth, double sceneHeight) {
        StackPane[] filledBoard = new StackPane[100];

        Rectangle[] tiles = makeBoardTiles(sceneWidth, sceneHeight);
        Label[] contents = setupBoardContents();
        eventHandler eventHandler = new eventHandler();
        for (int i = 0; i < 100; i += 10) {
            for (int j = 0; j < 10; j++) {
                StackPane filledTile = new StackPane();
                filledTile.setLayoutX((sceneWidth / 10.0) * j);
                filledTile.setLayoutY((sceneHeight / 100.0) * i);

                if (tiles[i + j].getFill() != Color.YELLOW) {
                    filledTile.setOnMouseClicked(eventHandler.tileClickedHandler);
                }
                filledTile.getChildren().addAll(tiles[i + j], contents[i + j]);
                filledBoard[i + j] = filledTile;

            }
        }

        return filledBoard;
    }
    
}
