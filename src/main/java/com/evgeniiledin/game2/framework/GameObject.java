package com.evgeniiledin.game2.framework;

import java.awt.*;
import java.io.IOException;

/**
 * Created by eugene on 01/05/2017.
 */
public abstract class GameObject {
    private int x;
    private int y;
    private float velX;
    private float velY;
    private Id id = Id.Movable;


    public GameObject(int x, int y, Id id) {
        this.x = x;
        this.y = y;
        this.id = id;

    }

    public GameObject() {

    }

    public abstract void tick() throws IOException;

    public abstract void render(Graphics2D g);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getVelX() {
        return velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }


    public Id getId() {
        return id;
    }

    public Rectangle getBounds() {
        Rectangle rec = new Rectangle(getX(), getY(), 32, 32);
        return rec;

    }

    public Rectangle getBoundsTop() {
        Rectangle rec = new Rectangle((getX() + 10), getY(), 32 - 20, 5);
        return rec;
    }

    public Rectangle getBoundsBottom() {

        return new Rectangle((getX() + 10), (getY() + 32), 32 - 20, 5);
    }

    public Rectangle getBoundsLeft() {

        return new Rectangle(getX(), (getY() + 10), 5, 32 - 20);
    }

    public Rectangle getBoundsRight() {
        return new Rectangle((getX() + 32 - 5), (getY() + 10), 5, 32 - 20);

    }

    public void changeId(Id id) {
        this.id = id;
    }

}
