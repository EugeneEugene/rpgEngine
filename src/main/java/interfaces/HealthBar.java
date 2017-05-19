package interfaces;

import com.evgeniiledin.game2.framework.GameObject;
import com.evgeniiledin.game2.framework.Id;
import com.evgeniiledin.game2.objects.Health;
import com.evgeniiledin.game2.window.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by eugene on 09/05/2017.
 */
public class HealthBar extends GameObject {
    Game game;
    ArrayList<Health> healthList;
    private BufferedImage heartImage;
    public HealthBar(int x, int y, int count_of_heart, Game game) throws IOException {
        super(x, y, Id.Movable);
        this.game = game;
        heartImage = ImageIO.read(new File("/Users/eugene/Desktop/heart.png"));
        healthList = new ArrayList<Health>();
        for (int i = 0; i < count_of_heart; i++) {
            healthList.add(new Health(i+5,5, Id.Movable));
        }
    }

    public void tick() {
        setX(game.getPlayer().getX() - 420);
        setY(game.getPlayer().getY() - 290);
    }

    public void render(Graphics2D g) {
        for (int i = 0; i < healthList.size(); i++) {
            g.drawImage(heartImage, getX() +(i+1)*32, getY(),null);
        }
    }

    public void render(Graphics g) {
//        g.setColor(Color.GREEN);
//        g.fillRect(getX(),getY() , 32, 32);
    }
}
