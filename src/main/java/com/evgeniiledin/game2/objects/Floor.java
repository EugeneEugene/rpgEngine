package com.evgeniiledin.game2.objects;

import com.evgeniiledin.game2.framework.GameObject;
import com.evgeniiledin.game2.framework.Id;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by eugene on 01/05/2017.
 */
public class Floor extends GameObject {

    private BufferedImage floorImage;

    public Floor(int x, int y, Id id) throws IOException {
        super(x * 32, y * 32, Id.Movable);
        floorImage = ImageIO.read(new File("/Users/eugene/Desktop/floor.png"));
    }

    public void tick() {
        return;
    }

    public void render(Graphics2D g) {
        g.drawImage(floorImage, getX(), getY(), null);
    }

}
