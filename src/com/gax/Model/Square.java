package com.gax.Model;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Author: Gác Xanh (phamanh)
 * Date: 19/12/2015
 * Class: OOP2
 * Project: 2048
 */
public class Square extends Sprite {
    private int value = 2;
    private final double sizeSquare = 57.0;
    private boolean active = false;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private static Square[][] instance;

    public static boolean[][] instanceActive(){
        boolean[][] listActive = new boolean[4][4];
        getSquareMatrix();
        for (int i = 0; i < listActive.length; i++) {
            for (int j = 0; j < listActive[i].length; j++) {
                listActive[i][j] = instance[i][j].active;
            }
        }
        return listActive;
    }

    public static Square[][] getSquareMatrix() {
        if (instance == null) {
            instance = new Square[4][4];
            for (int i = 0; i < instance.length; i++) {
                for (int j = 0; j < instance[i].length; j++) {
                    instance[i][j] = new Square(i, j);
                }
            }
            return instance;
        } else {
            return instance;
        }
    }

    public void setValue(int value) {
        this.value = value * 2;
    }

    private Square(int x, int y) {
        try {
            this.image = new Image(new FileInputStream("res/2.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.position = new Vector2D(30 + x * 67, 165 + y * 67);
        this.size = new Size(sizeSquare);
    }

}
