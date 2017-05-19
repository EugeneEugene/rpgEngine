package com.evgeniiledin.game2.objects;

import com.evgeniiledin.game2.framework.Id;
import com.evgeniiledin.game2.framework.Weapon;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by eugene on 12/05/2017.
 */
public class Sword extends Weapon {
    BufferedImage swordImage;

    public Sword(int x, int y, Id id) throws IOException {
        super(x * 32, y * 32, id);
        swordImage = ImageIO.read(new File("/Users/eugene/Desktop/sword_small.png"));
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
        g.drawImage(swordImage, getX(), getY(), null);
    }
}
