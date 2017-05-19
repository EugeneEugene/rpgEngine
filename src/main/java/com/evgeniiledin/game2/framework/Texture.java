package com.evgeniiledin.game2.framework;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by eugene on 13/05/2017.
 */
public class Texture {
    Spritesheet explosionSheet, statueSheet;
    BufferedImage explosionImage, statueImage;
    public BufferedImage[] exArr, statueArr;
    public Texture() throws IOException {
        exArr = new BufferedImage[16];
        statueArr = new BufferedImage[10];

        explosionImage = ImageIO.read(new File("/Users/eugene/Desktop/exp2_0.png"));
        statueImage = ImageIO.read(new File("/Users/eugene/Desktop/statue.png"));

        explosionSheet = new Spritesheet(explosionImage);
        statueSheet = new Spritesheet(statueImage);

        getTextures();
    }

    private void getTextures() {
        exArr[0] = explosionSheet.grabImage(1,1,64,64);
        exArr[1] = explosionSheet.grabImage(1,2,64,64);
        exArr[2] = explosionSheet.grabImage(1,3,64,64);
        exArr[3] = explosionSheet.grabImage(1,4,64,64);
        exArr[4] = explosionSheet.grabImage(2,1,64,64);
        exArr[5] = explosionSheet.grabImage(2,2,64,64);
        exArr[6] = explosionSheet.grabImage(2,3,64,64);
        exArr[7] = explosionSheet.grabImage(2,4,64,64);
        exArr[8] = explosionSheet.grabImage(3,1,64,64);
        exArr[9] = explosionSheet.grabImage(3,2,64,64);
        exArr[10] = explosionSheet.grabImage(3,3,64,64);
        exArr[11] = explosionSheet.grabImage(3,4,64,64);
        exArr[12] = explosionSheet.grabImage(4,1,64,64);
        exArr[13] = explosionSheet.grabImage(4,2,64,64);
        exArr[14] = explosionSheet.grabImage(4,3,64,64);
        exArr[15] = explosionSheet.grabImage(4,4,64,64);

        statueArr[0] = statueSheet.grabImage(1,1, 16,16);
        statueArr[1] = statueSheet.grabImage(2,1, 16,16);
        statueArr[2] = statueSheet.grabImage(3,1, 16,16);
        statueArr[3] = statueSheet.grabImage(4,1, 16,16);
        statueArr[4] = statueSheet.grabImage(5,1, 16,16);
        statueArr[5] = statueSheet.grabImage(1,2, 16,16);
        statueArr[6] = statueSheet.grabImage(2,2, 16,16);
        statueArr[7] = statueSheet.grabImage(3,2, 16,16);
        statueArr[8] = statueSheet.grabImage(4,2, 16,16);
        statueArr[9] = statueSheet.grabImage(5,2, 16,16);

    }
}
