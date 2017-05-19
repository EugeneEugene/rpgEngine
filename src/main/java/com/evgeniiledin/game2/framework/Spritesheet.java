package com.evgeniiledin.game2.framework;

import java.awt.image.BufferedImage;

/**
 * Created by eugene on 13/05/2017.
 */
public class Spritesheet {

    private BufferedImage image;

    public Spritesheet(BufferedImage image) {
         this.image = image;
    }

    public BufferedImage grabImage(int col, int row, int width, int height) {
        BufferedImage img = image.getSubimage((col * width - width),(row * height - height), width, height);
        return img;
    }
}
