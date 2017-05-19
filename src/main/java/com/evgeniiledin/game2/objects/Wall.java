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
public class Wall extends GameObject {

    private BufferedImage wallImage;

    public Wall(int x, int y, Id id) throws IOException {
        super(x * 32, y * 32, Id.Notmovable);
        wallImage = ImageIO.read(new File("/Users/eugene/Desktop/00.png"));
    }

    public void tick() {
        return;
    }

    public void render(Graphics2D g) {
        g.drawImage(wallImage, getX(), getY(), null);
    }

}
