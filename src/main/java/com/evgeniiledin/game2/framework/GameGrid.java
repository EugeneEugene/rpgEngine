package com.evgeniiledin.game2.framework;

/**
 * Created by eugene on 03/05/2017.
 */
public class GameGrid {
    private GameObject[][] grid;
    private int dimension1;
    private int dimension2;

    public GameGrid(int dimension1, int dimension2) {
        this.dimension1 = dimension1;
        this.dimension2 = dimension2;
        this.grid = new GameObject[dimension1][dimension2];
    }

    public int getVerticalDimension() {
        return dimension1;
    }

    public int getHorizontalDimension() {
        return dimension2;
    }

    public GameObject[][] getGrid() {
        return grid;
    }

}
