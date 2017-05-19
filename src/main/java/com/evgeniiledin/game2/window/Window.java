package com.evgeniiledin.game2.window;

import javax.swing.*;
import java.awt.*;

/**
 * Created by eugene on 01/05/2017.
 */
public class Window {


    public Window(int w, int h, String title, Game game) {
        game.setPreferredSize(new Dimension(w, h));
        game.setMaximumSize(new Dimension(w, h));
        game.setMinimumSize(new Dimension(w, h));


        JFrame jFrame = new JFrame(title);
        jFrame.add(game);
        jFrame.pack();
        jFrame.setDefaultCloseOperation(3);
        jFrame.setResizable(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setFocusable(false);


    }

    public static void main(String[] args) throws InterruptedException {
        final Game game = new Game();
        new Window(1800, 1200, "V 2.0", game);
        game.start();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                game.setVisible(true);
            }
        });

    }
}
