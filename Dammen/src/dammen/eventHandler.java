/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dammen;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

/**
 *
 * @author Hans
 */
public class eventHandler {

    static int action = 0, thisPane = 0;
    static Color color = Color.WHITE;
    EventHandler<MouseEvent> tileClickedHandler = (MouseEvent event) -> {
        StackPane[] board = Dammen.currentBoard;

        for (int i = 0; i < 100; i++) {

            if (board[i].equals(event.getSource())) {
                Label currentLabel = (Label) board[i].getChildren().get(1);

                if (action == 0 && labelEqualsX(currentLabel)) {
                    color = (Color) currentLabel.getTextFill();
                    board[i].getChildren().remove(1);
                    board[i].getChildren().add(MakeBoard.makeLabel(null, null));
                    thisPane = i;
                    action = 1;
                } 
                else if (action == 1 && (!labelEqualsX(currentLabel))) {
                    if (board[thisPane].equals(board[i])) {
                        moveX(board[i]);
                    }
                    else if (blackCheck(board, i) || whiteCheck(board, i)) {
                        moveX(board[i]);
                    }
                }
                break;
            }
        }
    };

    private boolean labelEqualsX(Label currentLabel) {
        return currentLabel.getText().equals("x");
    }

    private boolean blackCheck(StackPane[] board, int i) {
        return color == Color.BLACK && (board[thisPane + 11].equals(board[i]) || board[thisPane + 9].equals(board[i]));
    }

    private boolean whiteCheck(StackPane[] board, int i) {
        return color == Color.WHITE && (board[thisPane - 11].equals(board[i]) || board[thisPane - 9].equals(board[i]));
    }

    private void moveX(StackPane board) {
        board.getChildren().remove(1);
        board.getChildren().add(MakeBoard.makeLabel("x", color));
        action = 0;
    }
}
