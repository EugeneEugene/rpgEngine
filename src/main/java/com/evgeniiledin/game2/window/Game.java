package com.evgeniiledin.game2.window;

import com.evgeniiledin.game2.framework.*;
import com.evgeniiledin.game2.objects.Enemy;
import com.evgeniiledin.game2.objects.Player;
import com.evgeniiledin.game2.objects.Room;
import com.evgeniiledin.game2.objects.Wall;
import interfaces.HealthBar;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by eugene on 01/05/2017.
 */
public class Game extends JPanel implements Runnable {

    private boolean running = false;
    private Thread thread;


    private GameGrid gameGrid;
    private Player player;
    private Position playerPosition;
    private Position enemyPosition;
    private Enemy enemy;
    private boolean created;

    private Texture tex;

    private Handler hander;
    private Controller controller;
    private HealthBar healthBar;

    private Room startRoom;


    private LevelGenerator levelGenerator;
    Camera camera;
    GameObject[][] grid;

    public ArrayList<GameObject> listOfIngameObject;

    private void init() throws IOException, InterruptedException {
        setDoubleBuffered(true);

        listOfIngameObject = new ArrayList<GameObject>();
        tex = new Texture();
        camera = new Camera(0, 0);
        hander = new Handler();
        gameGrid = new GameGrid(2560 / 32, 1600 / 32);
        grid = gameGrid.getGrid();

        for (int i = 1; i < gameGrid.getVerticalDimension(); i++) {
            for (int j = 1; j < gameGrid.getHorizontalDimension(); j++) {
                Wall wall = new Wall(j, i, Id.Notmovable);
                hander.addobject(wall);
                grid[i][j] = wall;
            }
        }
        levelGenerator = new LevelGenerator(4, this);
        levelGenerator.generate(2);

        startRoom = (Room) levelGenerator.getRoomList().get(0);

        playerPosition = startRoom.getCenter();
        Room enemyRoom = (Room) levelGenerator.getRoomList().get(1);
        enemyPosition = enemyRoom.getCenter();

        player = new Player(playerPosition.getX() * 32, playerPosition.getY() * 32, this);
        camera = new Camera(player.getX(), player.getY());
        healthBar = new HealthBar(0, 0, 3, this);
        enemy = new Enemy(enemyPosition.getX() * 32, enemyPosition.getY() * 32, this);

        hander.addList(levelGenerator.getRoomList());
        hander.addList(levelGenerator.getCoridorList());
        hander.addobject(player);
        hander.addobject(enemy);
        hander.addList(listOfIngameObject);
        hander.addobject(healthBar);

        controller = new Controller(this);

        created = true;

    }

    public synchronized void start() {
        if (running) {
            return;
        }

        running = true;
        thread = new Thread(this);
        thread.start();

    }

    public void run() {
        this.requestFocus();
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long lastTime = System.nanoTime();
        final double ticks = 30.0;
        double ns = 1000000000 / ticks;
        double delta = 0;
        int frames = 0;
        int updates = 0;
        long timer = System.currentTimeMillis();

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                try {
                    tick();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                render();
                updates++;
                delta--;
            }
            this.requestFocus();

            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
//                 System.out.println(updates + "Ticks, Fps " + frames );
                updates = 0;
                frames = 0;
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
            }

        }
//        stop();
    }

    private void tick() throws IOException {
        hander.tick();
        camera.tick(player);
        controller.use();
    }


    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 1600, 1200);
        if (created) {
            g2d.translate(camera.getX(), camera.getY());
            hander.render(g2d);
            g2d.translate(-camera.getX(), -camera.getY());
        }

    }

    private void render() {
        repaint();
    }

    public Texture getInstance() {
        return tex;
    }

    public Player getPlayer() {
        return player;
    }

    public GameGrid getGameGrid() {
        return gameGrid;
    }

    public Handler getHander() {
        return hander;
    }


}
