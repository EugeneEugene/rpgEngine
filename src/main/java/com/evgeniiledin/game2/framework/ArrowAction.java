package com.evgeniiledin.game2.framework;

import com.evgeniiledin.game2.objects.Player;
import com.evgeniiledin.game2.objects.Shuriken;
import com.evgeniiledin.game2.window.Handler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by eugene on 15/04/2017.
 */
public class ArrowAction extends AbstractAction{

    private String cmd;
    private Player player;
    private ArrayList<Shuriken> shurikenList;
    private Handler handler;

    public ArrowAction(String cmd, Player player)  {
        this.cmd = cmd;
        this.player = player;
        this.handler = player.getGame().getHander();
        shurikenList = player.getShurikenList();
    }

    public void actionPerformed(ActionEvent e) {

        if (cmd.equalsIgnoreCase("LeftArrow")) {
            player.setVelX(-2);

        } else if (cmd.equalsIgnoreCase("RightArrow")) {
            player.setVelX(2);

        } else if (cmd.equalsIgnoreCase("UpArrow")) {
            player.setVelY(-2);

        } else if (cmd.equalsIgnoreCase("DownArrow")) {
            player.setVelY(2);

        } else if (cmd.equalsIgnoreCase("LeftArrowReleased")) {
            player.setVelX(0);

        } else if (cmd.equalsIgnoreCase("RightArrowReleased")) {
            player.setVelX(0);

        } else if (cmd.equalsIgnoreCase("UpArrowReleased")) {
            player.setVelY(0);

        } else if (cmd.equalsIgnoreCase("DownArrowReleased")) {
            player.setVelY(0);

        }
        else if (cmd.equalsIgnoreCase("D_Pushed")) {
            try {
                if (player.countOfShuriken > 0) {
                Shuriken shuriken = new Shuriken(player.getX()/32, player.getY()/32, Id.Movable, player.getGame());
                shuriken.setVelX(2);
                handler.getObjectList().add(shuriken);
                handler.getShurikenList().add(shuriken);
                player.countOfShuriken--;
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        else if (cmd.equalsIgnoreCase("A_Pushed")) {
            try {
                if (player.countOfShuriken > 0) {
                    Shuriken shuriken = new Shuriken(player.getX() / 32, player.getY() / 32, Id.Movable, player.getGame());
                    shuriken.setVelX(-2);
                    handler.getObjectList().add(shuriken);
                    handler.getShurikenList().add(shuriken);
                    player.countOfShuriken--;
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        else if (cmd.equalsIgnoreCase("S_Pushed")) {
            try {
                if (player.countOfShuriken > 0) {
                    Shuriken shuriken = new Shuriken(player.getX() / 32, player.getY() / 32, Id.Movable, player.getGame() );
                    shuriken.setVelY(2);
                    handler.getObjectList().add(shuriken);
                    handler.getShurikenList().add(shuriken);
                    player.countOfShuriken--;
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        else if (cmd.equalsIgnoreCase("W_Pushed")) {
            try {
                if (player.countOfShuriken > 0) {
                    Shuriken shuriken = new Shuriken(player.getX() / 32, player.getY() / 32, Id.Movable, player.getGame());
                    shuriken.setVelY(-2);
                    handler.getObjectList().add(shuriken);
                    handler.getShurikenList().add(shuriken);
                    player.countOfShuriken--;
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
}
}

