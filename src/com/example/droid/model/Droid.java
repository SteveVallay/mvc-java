
package com.example.droid.model;

public class Droid {

    private float x = 0;
    private float y = 0;
    private float speed = 10f;
    private float rotation = 0f;
    private float damage = 2f;

    public Droid() {
    }

    public Droid(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getY() {
        return y;
    }

    public void setSpeed(float sp) {
        speed = sp;
    }

    public float getSpeed() {
        return speed;
    }

    public void setRotation(float ro) {
        rotation = ro;
    }

    public float getRotation() {
        return rotation;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public float getDamage() {
        return damage;
    }
}
