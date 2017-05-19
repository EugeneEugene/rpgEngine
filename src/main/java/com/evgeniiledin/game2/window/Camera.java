package com.evgeniiledin.game2.window;

import com.evgeniiledin.game2.framework.GameObject;

/**
 * Created by eugene on 02/05/2017.
 */
public class Camera {

    private float x;
    private float y;

    public Camera(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void tick(GameObject player) {
        x = -player.getX() + 800 / 2;
        y = -player.getY() + 600 / 2;
    }
}
