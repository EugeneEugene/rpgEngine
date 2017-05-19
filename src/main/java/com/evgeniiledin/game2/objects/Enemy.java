package com.evgeniiledin.game2.objects;

import com.evgeniiledin.game2.framework.GameObject;
import com.evgeniiledin.game2.framework.Id;
import com.evgeniiledin.game2.window.Game;

import java.awt.*;

/**
 * Created by eugene on 09/05/2017.
 */
public class Enemy extends GameObject {

    private Game game;

    public Enemy(int x, int y, Game game) {
        super(x, y, Id.Notmovable);
        this.game = game;
    }

    public void tick() {
        setX(getX() + (int) getVelX());
        setY(getY() + (int) getVelY());
        for (GameObject go : game.getHander().getObjectList()) {
            if (go.getId() == Id.Notmovable && (go instanceof Wall || go instanceof Player)) {

                if (getBoundsTop().intersects(go.getBounds())) {
                    setVelY(0);
                    setY(go.getY() + 32);
                }
                if (this.getBoundsBottom().intersects(go.getBounds())) {
                    setVelY(0);
                    setY(go.getY() - 32);
                }
                if (getBoundsLeft().intersects(go.getBounds())) {
                    setVelX(0);
                    setX(go.getX() + 32);
                }
                if (getBoundsRight().intersects(go.getBounds())) {
                    setVelX(0);
                    setX(go.getX() - 32);
                } else {
                    setVelY(1);
                    setVelX(1);
                }
            }
        }
    }

    public Rectangle getBounds() {
        Rectangle rec = new Rectangle(getX(), getY(), 32, 32);
        return rec;
    }

    public void render(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillRect(getX(), getY(), 32, 32);
    }
}
