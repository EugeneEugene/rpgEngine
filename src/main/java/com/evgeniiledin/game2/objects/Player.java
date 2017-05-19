package com.evgeniiledin.game2.objects;

import com.evgeniiledin.game2.framework.GameObject;
import com.evgeniiledin.game2.framework.Id;
import com.evgeniiledin.game2.framework.Texture;
import com.evgeniiledin.game2.window.Game;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by eugene on 01/05/2017.
 */
public class Player extends GameObject {
    private Game game;
    Texture tex;
    private ArrayList<Shuriken> shurikenList;
    public int countOfShuriken;

    public Player(int x, int y, Game game) {
        super(x, y, Id.Notmovable);
//        tex = game.getInstance();
        this.game = game;
        countOfShuriken = 20;
        shurikenList = new ArrayList<Shuriken>();
//        playerWalk = new Animation(100, tex.exArr[1],tex.exArr[2], tex.exArr[3]);

    }

    public void tick() {
        setX(getX() + (int) getVelX());
        setY(getY() + (int) getVelY());

//        playerWalk.runAnimation();animation.drawAnimation(g, x , y );
        for (GameObject go : game.getHander().getObjectList()) {
            if (go.getId() == Id.Notmovable && (go instanceof Wall || go instanceof Enemy)) {

                if (getBoundsTop().intersects(go.getBounds())) {
                    setVelY(0);
                    setY(go.getY() + 32);
                }
                if (this.getBoundsBottom().intersects(go.getBounds())) {
                    setVelY(0);
                    setY(go.getY() - 35);
                }
                if (getBoundsLeft().intersects(go.getBounds())) {
                    setVelX(0);
                    setX(go.getX() + 32);
                }
                if (getBoundsRight().intersects(go.getBounds())) {
                    setVelX(0);
                    setX(go.getX() - 32);
                }
            }
        }
    }

    public void render(Graphics2D g) {
        g.setColor(Color.CYAN);
        g.fillRect(getX(), getY(), 32, 32);
//        playerWalk.drawAnimation(g, x, y);
    }

    public Rectangle getBounds() {
        Rectangle rec = new Rectangle(getX(), getY(), 32, 32);
        return rec;
    }

    public Game getGame() {
        return game;
    }

    public ArrayList<Shuriken> getShurikenList() {
        return shurikenList;
    }


}
