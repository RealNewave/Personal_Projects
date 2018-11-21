/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dammen;

import javafx.scene.paint.Color;

/**
 *
 * @author Hans
 */
public class BoardTile {
    
    private double width;
    private double height;
    private Color fill;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Color getFill() {
        return fill;
    }

    public final void setFill(Color fill) {
        this.fill = fill;
    }

}
