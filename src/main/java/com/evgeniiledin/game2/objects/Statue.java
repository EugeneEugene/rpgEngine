package com.evgeniiledin.game2.objects;

import com.evgeniiledin.game2.framework.GameObject;
import com.evgeniiledin.game2.framework.Id;
import com.evgeniiledin.game2.framework.Texture;
import com.evgeniiledin.game2.window.Animation;
import com.evgeniiledin.game2.window.Game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by eugene on 13/05/2017.
 */
public class Statue extends GameObject {

    private Game game;
    private BufferedImage statueImage;
    private boolean explose;
    private Id id;
    private Animation animation;
    private Texture texture;

    public Statue(int x, int y, Game game) throws IOException {
        super(x * 32, y * 32, Id.Movable);
        this.game = game;
        this.texture = game.getInstance();
        this.id = Id.Movable;
        texture = this.game.getInstance();

        this.animation = new Animation(Integer.MAX_VALUE, texture.exArr[0], texture.exArr[1],
                texture.exArr[2], texture.exArr[3], texture.exArr[4], texture.exArr[5], texture.exArr[6],
                texture.exArr[7], texture.exArr[8], texture.exArr[9], texture.exArr[10], texture.exArr[11],
                texture.exArr[12], texture.exArr[13], texture.exArr[14], texture.exArr[15]);
        Random rand = new Random();

        int randomNum = rand.nextInt((8 - 0) + 1) + 0;

        switch (randomNum) {
            case 0:
                this.statueImage = texture.statueArr[0];
                break;
            case 1:
                this.statueImage = texture.statueArr[1];
                break;
            case 2:
                this.statueImage = texture.statueArr[2];
                break;
            case 3:
                this.statueImage = texture.statueArr[3];
                break;
            case 4:
                this.statueImage = texture.statueArr[4];
                break;
            case 5:
                this.statueImage = texture.statueArr[5];
                break;
            case 6:
                this.statueImage = texture.statueArr[6];
                break;
            case 7:
                this.statueImage = texture.statueArr[7];
                break;
            case 8:
                this.statueImage = texture.statueArr[8];
                break;
            case 9:
                this.statueImage = texture.statueArr[9];
                break;
        }

    }

    public void tick() {
        if (getId() == Id.Explosive) {
            animation.runAnimation();
        }
    }

    public void changeId(Id id1) {
        id = id1;
    }

    public Id getId() {
        return id;
    }


    public void render(Graphics2D g) {
        System.out.println();
        if (getId() != Id.Explosive) {
            g.drawImage(statueImage, (this.getX() + 8), (this.getY() + 8), null);
        } else {
            animation.drawAnimation(g, getX(), getY());
        }
    }
}
