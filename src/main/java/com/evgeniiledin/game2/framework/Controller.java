package com.evgeniiledin.game2.framework;

import com.evgeniiledin.game2.window.Game;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Created by eugene on 15/04/2017.
 */
public class Controller {
    InputMap im;
    ActionMap am;
    Game game;

    public Controller(Game game) {
        this.game = game;
    }

    public void use() {
        im = game.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        am = game.getActionMap();
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "RightArrow");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "LeftArrow");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "UpArrow");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "DownArrow");


        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "RightArrowReleased");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "LeftArrowReleased");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "UpArrowReleased");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "DownArrowReleased");


        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "D_Pushed");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "A_Pushed");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "W_Pushed");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "S_Pushed");


        am.put("RightArrow", new ArrowAction("RightArrow", game.getPlayer()));
        am.put("LeftArrow", new ArrowAction("LeftArrow", game.getPlayer()));
        am.put("UpArrow", new ArrowAction("UpArrow", game.getPlayer()));
        am.put("DownArrow", new ArrowAction("DownArrow", game.getPlayer()));


        am.put("RightArrowReleased", new ArrowAction("RightArrowReleased", game.getPlayer()));
        am.put("LeftArrowReleased", new ArrowAction("LeftArrowReleased", game.getPlayer()));
        am.put("UpArrowReleased", new ArrowAction("UpArrowReleased", game.getPlayer()));
        am.put("DownArrowReleased", new ArrowAction("DownArrowReleased", game.getPlayer()));


        am.put("D_Pushed", new ArrowAction("D_Pushed", game.getPlayer()));
        am.put("A_Pushed", new ArrowAction("A_Pushed", game.getPlayer()));
        am.put("W_Pushed", new ArrowAction("W_Pushed", game.getPlayer()));
        am.put("S_Pushed", new ArrowAction("S_Pushed", game.getPlayer()));
    }

}

