
package com.example.droid.model;

public class Enemy {

    private float x = 0f;
    private float y = 0f;
    private int hit = 0;

    public Enemy(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int xx) {
        x = xx;
    }

    public float getX() {
        return x;
    }

    public void setY(int yy) {
        y = yy;
    }

    public float getY() {
        return y;
    }

    public void setHit(int h) {
        hit = h;
    }

    public int getHit() {
        return hit;
    }
}
