package com.evgeniiledin.game2.objects;

import com.evgeniiledin.game2.framework.GameObject;
import com.evgeniiledin.game2.framework.Id;
import com.evgeniiledin.game2.framework.Weapon;
import com.evgeniiledin.game2.window.Game;
import com.evgeniiledin.game2.window.Handler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by eugene on 13/05/2017.
 */
public class Shuriken extends Weapon {
    BufferedImage shoorikenImage;
    Game game;
    Handler hander;

    public Shuriken(int x, int y, Id id, Game game) throws IOException {
        super(x * 32, y * 32, id);
        shoorikenImage = ImageIO.read(new File("/Users/eugene/Desktop/shuriken1.png"));
        this.game = game;
        this.hander = game.getHander();
    }

    public void tick() throws IOException {
        setX(getX() + (int) getVelX());
        setY(getY() + (int) getVelY());
        for (Statue statue : hander.getStatueList()) {
            if (Math.abs(statue.getX() - getX()) < 30 && Math.abs(statue.getY() - getY()) < 30) {
//                statue.changeId(Id.Invisible);
                statue.changeId(Id.Explosive);
                changeId(Id.Invisible);
            }
        }
        for (GameObject o : hander.getObjectList()) {
            if (o instanceof Wall) {
                if ((o.getX() == getX()) && (o.getY() == getY())) {
                    changeId(Id.Invisible);
                }
            }
        }

    }


    public void render(Graphics2D g) {
        super.render(g);
        g.drawImage(shoorikenImage, getX(), getY(), null);

    }
}
