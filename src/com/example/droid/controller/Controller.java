
package com.example.droid.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.example.droid.model.Arena;
import com.example.droid.model.Droid;

public class Controller implements MouseListener {
    private static final int unit = Arena.SIZE;
    Arena mArena;
    private float targetX, targetY;
    /** true if the droid moves **/
    private boolean moving = false;

    public Controller(Arena arena) {
        mArena = arena;
    }

    public void update(float delta) {
        Droid droid = mArena.getDroid();
        if (moving) {
            // move on X
            int bearing = 1;
            if (droid.getX() > targetX) {
                bearing = -1;
            }
            if (droid.getX() != targetX) {
                droid.setX(droid.getX() + bearing * droid.getSpeed() * delta);
                // check if arrived
                if ((droid.getX() < targetX && bearing == -1)
                        || (droid.getX() > targetX && bearing == 1))
                    droid.setX(targetX);
            }
            // move on Y
            bearing = 1;
            if (droid.getY() > targetY) {
                bearing = -1;
            }
            if (droid.getY() != targetY) {
                droid.setY(droid.getY() + bearing * droid.getSpeed() * delta);
                // check if arrived
                if ((droid.getY() < targetY && bearing == -1)
                        || (droid.getY() > targetY && bearing == 1))
                    droid.setY(targetY);
            }
            // check if arrived
            if (droid.getX() == targetX && droid.getY() == targetY)
                moving = false;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("event " + e);
        targetX = e.getX() / unit;
        targetY = e.getY() / unit;
        if (mArena.getGrid()[(int) targetY][(int) targetX] == null) {
            moving = true;
        }
    }

}
