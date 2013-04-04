
package com.example.droid;

import com.example.droid.controller.GameEngine;

public class Droids {
    public static final String NAME = "droid example";
    public static final int WIDTH = 480;
    public static final int HEIGHT = 320;

    public static void main(String args[]) {
        GameEngine gEngine = new GameEngine();
        gEngine.start();
    }
}
