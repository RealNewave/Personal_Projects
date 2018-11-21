/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package follow;

import javafx.scene.layout.Pane;

/**
 *
 * @author Hans
 */
public class Chaser {

    private int size;
    private int maxSpeed;
    private double currentSpeedY;
    private double currentSpeedX;

    private Pane pane;

    public Chaser(int size, int maxSpeed, Pane pane) {
        this.size = size;
        this.maxSpeed = maxSpeed;
        this.pane = pane;
        currentSpeedX = 0;
        currentSpeedY = 0;
    }

    public double getCurrentSpeedX() {
        return currentSpeedX;
    }

    public void setCurrentSpeedX(double currentSpeedX) {
        this.currentSpeedX = currentSpeedX;
    }

    public double getCurrentSpeedY() {
        return currentSpeedY;
    }

    public void setCurrentSpeedY(double currentSpeedY) {
        this.currentSpeedY = currentSpeedY;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int speed) {
        this.maxSpeed = speed;
    }

    public Pane getPane() {
        return pane;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }

}
