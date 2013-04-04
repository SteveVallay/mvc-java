package com.example.droid;

import javax.swing.JFrame;

public class Droids {

    public static final String NAME = "droid example";
    public static final int WIDTH = 480;
    public static final int HEIGHT = 320;

    public static void main(String args[]){
        JFrame jFrame =    new JFrame(NAME);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(WIDTH, HEIGHT);
        jFrame.setVisible(true);
    }
}
