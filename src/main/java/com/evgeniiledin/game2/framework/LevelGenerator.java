package com.evgeniiledin.game2.framework;

import com.evgeniiledin.game2.objects.Room;
import com.evgeniiledin.game2.window.Game;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by eugene on 01/05/2017.
 */
public class LevelGenerator {

    ArrayList<Room> roomList = new ArrayList<Room>();
    ArrayList<Room> coridorList = new ArrayList<Room>();

    Game game;
    int numberOFrRoom;
    GameGrid gameGrid;

    public LevelGenerator(int numberOfrRooms, Game game) {
        this.game = game;
        this.numberOFrRoom = numberOfrRooms;
        this.gameGrid = game.getGameGrid();


    }


    public void generate(int numberOfrRooms) throws IOException {
        int i = 0;
        while(i < numberOfrRooms) {


            int w = 10 + (int)(Math.random() * ((gameGrid.getHorizontalDimension()/3) - 4 + 1));
            int h = 10 + (int)(Math.random() * ((gameGrid.getVerticalDimension()/3) - 4 + 1));
            int x = 2 + (int)(Math.random() * ((gameGrid.getHorizontalDimension()) - w -2));
            int y = 2 + (int)(Math.random() * ((gameGrid.getVerticalDimension()) - h -2));


            Room room = new Room(i,x ,y ,w, h, game);
//            Room room = new Room(i,y ,x ,h, w, game);

            boolean failed = false;

            for (Room createdRoom : roomList) {
                if (room.intersects(createdRoom)) {
                    failed = true;
                    break;
                }
            }
            if (!failed) {
                if (room.getIndex() != 0) {
                    Position neighborCenter = roomList.get(room.getIndex() - 1).getCenter();
                    int randomNum = 1 + (int)(Math.random() * 2);
                    if (randomNum == 1) {
                        hCorridor(neighborCenter.getX(), room.getCenter().getX(), neighborCenter.getY());
                        vCorridor(neighborCenter.getY(), room.getCenter().getY(), room.getCenter().getX());
                    }
                    else {
                        vCorridor(neighborCenter.getY(), room.getCenter().getY(),
                                neighborCenter.getX());
                        hCorridor(neighborCenter.getX(), room.getCenter().getX(),
                                room.getCenter().getY());
                    }
                }
                roomList.add(room);
                room.generateStatues();
                room.updayecol();
                i++;

        }}}


    private void hCorridor(int x1, int x2, int y) throws IOException {
        int maxX = Math.max(x1, x2);
        int minX = Math.min(x1, x2);
        for (int x = minX; x < maxX; x++) {
            Room room = new Room(coridorList.size() + 1, x,y,2,2, game);
            room.updayecol();
            coridorList.add(room);


        }
    }

    private void vCorridor(int y1, int y2, int x) throws IOException {
        int maxY = Math.max(y1, y2);
        int minY = Math.min(y1, y2);
        for (int y = minY; y < maxY; y++) {
            Room room = new Room(coridorList.size() + 1, x,y,2,2, game);
            room.updayecol();
            coridorList.add(room);
        }

    }

    public void render(Graphics2D g) {
        for (Room room:
             roomList) {
            room.render(g);
        }
    }

    public ArrayList getRoomList() {
        return roomList;
    }

    public ArrayList getCoridorList() {return coridorList;}

}
