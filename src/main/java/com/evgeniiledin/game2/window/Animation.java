package com.evgeniiledin.game2.window;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by eugene on 13/05/2017.
 */
public class Animation {
    private int speed;
    private int frames;
    private int index;
    private int count;

    private BufferedImage[] images;
    private BufferedImage currentImage;

    public Animation(int speed, BufferedImage... args) {
        this.speed = speed;
        images = new BufferedImage[args.length];

        for (int i = 0; i < args.length; i++) {
            images[i] = args[i];
        }
        frames = args.length;
    }

    public void runAnimation() {
        index++;
        if (index < speed) {
            index = 0;
            nextFrame();
        }

    }

    public void nextFrame() {
        for (int i = 0; i < frames; i++) {
            if (count == i) {
                currentImage = images[i];
            }
        }
        count++;

//        if(count > frames) {
//            count = 0;
//        }
    }

    public void drawAnimation(Graphics2D g, int x, int y) {
        g.drawImage(currentImage, x, y, null);
    }

    public void drawAnimation(Graphics2D g, int x, int y, int scaleX, int scaleY) {
        g.drawImage(currentImage, x, y, scaleX, scaleY, null);
    }

}
