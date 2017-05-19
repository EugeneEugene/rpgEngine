package com.evgeniiledin.game2.window;

import com.evgeniiledin.game2.framework.Controller;
import com.evgeniiledin.game2.framework.GameObject;
import com.evgeniiledin.game2.framework.Id;
import com.evgeniiledin.game2.objects.Floor;
import com.evgeniiledin.game2.objects.Shuriken;
import com.evgeniiledin.game2.objects.Statue;
import com.evgeniiledin.game2.objects.Wall;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by eugene on 01/05/2017.
 */
public class Handler {

    Controller controller;
    Animation animationExpo;

    public Handler() {
        animationExpo = new Animation(10);
    }


    private LinkedList<GameObject> objectList = new LinkedList<GameObject>();
    private LinkedList<Shuriken> shurikenList = new LinkedList<Shuriken>();
    private LinkedList<Statue> statueList = new LinkedList<Statue>();
    private LinkedList<Wall> wallList = new LinkedList<Wall>();
    private LinkedList<Floor> floorList = new LinkedList<Floor>();


    public void tick() throws IOException {
        for (GameObject object :
                objectList) {
            object.tick();
        }
    }

    public void render(Graphics2D g) {
        if (objectList.size() > 1)
            for (GameObject object :
                    objectList) {
                if (object.getId() != Id.Invisible) {
                    object.render(g);
                }
            }
    }

    public void addobject(GameObject object) {
        objectList.add(object);
    }

    public void addList(ArrayList<GameObject> list) {
        objectList.addAll(list);
    }


    public LinkedList<GameObject> getObjectList() {
        return objectList;
    }

    public LinkedList<Shuriken> getShurikenList() {
        return shurikenList;
    }

    public LinkedList<Floor> getFloorList() {
        return floorList;
    }

    public LinkedList<Statue> getStatueList() {
        return statueList;
    }

}
