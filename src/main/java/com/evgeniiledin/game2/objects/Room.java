package com.evgeniiledin.game2.objects;

import com.evgeniiledin.game2.framework.GameObject;
import com.evgeniiledin.game2.framework.Id;
import com.evgeniiledin.game2.framework.Position;
import com.evgeniiledin.game2.window.Game;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by eugene on 01/05/2017.
 */
public class Room extends GameObject {

    private int xLeft;
    private int xRight;
    private int yLeft;
    private int yRight;
    private int index;

    private Position centerPosition;

    private int w;
    private int h;
    private Floor floor;

    private GameObject[][] gameGrid;


    private ArrayList<Floor> roomSpace;
    private ArrayList<Wall> wallSpace;
    private Game game;
    private LinkedList<GameObject> collissionlis;


    public Room(int index, int x, int y, int w, int h, Game game) throws IOException {
        super(x, y, Id.Movable);
        gameGrid = game.getGameGrid().getGrid();
        xLeft = x;
        yLeft = y;
        xRight = x + w;
        yRight = y + h;
        gameGrid = game.getGameGrid().getGrid();
        collissionlis = new LinkedList<GameObject>();
        this.game = game;


        this.index = index;

        this.centerPosition = new Position((int) Math.floor((xLeft + xRight) / 2),
                (int) Math.floor((yLeft + yRight) / 2));
        roomSpace = new ArrayList<Floor>();
        wallSpace = new ArrayList<Wall>();

        for (int i = xLeft; i < xRight; i++) {
            for (int j = yLeft; j < yRight; j++) {
                floor = new Floor(i, j, Id.Movable);
//                game.getHander().getObjectList().remove(gameGrid[j][i]);
                roomSpace.add(floor);
                game.getHander().getFloorList().add(floor);
                wallSpace.add((Wall) game.getGameGrid().getGrid()[j][i]);


//                game.getHander().getObjectList().add(floor);
            }
        }
    }

    public float getxLeft() {
        return xLeft;
    }

    public float getyLeft() {
        return yLeft;
    }

    public float getxRight() {
        return xRight;
    }

    public float getyRight() {
        return yRight;
    }

    public boolean intersects(Room room) {
        return (xLeft <= room.xRight && xRight >= room.xLeft &&
                yLeft <= room.yRight && room.yRight >= room.yLeft);
    }

    public void tick() {
        return;
    }

    public void render(Graphics2D g) {
        for (Floor floor :
                roomSpace) {
            floor.render(g);
        }
    }


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Position getCenter() {
        return centerPosition;
    }

    public void updayecol() {
        game.getHander().getObjectList().addAll(roomSpace);
        game.getHander().getObjectList().removeAll(wallSpace);
    }

//    public boolean inRoom(int x, int y) {
//        if (x >= xLeft && x <= xRight && y >= yLeft && y <= yRight) {
//            return true;
//    }
//    else {
//            return false;
//        }
//    }

    public void generateStatues() throws IOException {
        int x;
        int y;
        Statue statue;
        Random rand = new Random();
        int countOfStaue = rand.nextInt((4 - 0) + 1) + 0;
        for (int i = 0; i < 4; i++) {
            x = rand.nextInt((xRight - 4 - xLeft + 1) + 1) + xLeft + 1;
            y = rand.nextInt((yRight - 4 - yLeft + 1) + 1) + yLeft + 1;
            System.out.println("kek");


            statue = new Statue(x, y, game);
            game.listOfIngameObject.add(statue);
            game.getHander().getStatueList().add(statue);
        }
    }
}
