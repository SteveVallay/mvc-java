
package com.example.droid.view;

import java.awt.Color;
import java.awt.Graphics;

import com.example.droid.Droids;
import com.example.droid.model.Arena;
import com.example.droid.model.Droid;
import com.example.droid.model.Enemy;
import com.example.droid.model.Obstacle;

public class DroidsRenderer implements Renderer {

    private Arena arena;
    Color gridColor = new Color(0, 0.5f, 0, 0.75f);
    Color obsColor = new Color(0, 0, 1f);
    Color eneColor = new Color(0, 1f, 0f);
    Color droidColor = new Color(1f, 0, 0);

    public DroidsRenderer(Arena a) {
        arena = a;
    }

    @Override
    public void render(Graphics g) {
        // render the grid
        // why not let the Arena draw it itself.
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Droids.WIDTH, Droids.HEIGHT);
        int cellSize = Arena.SIZE;
        // draw line horizonally
        g.setColor(gridColor);
        for (int i = 0; i <= Arena.WIDTH; i++) {
            g.drawLine(i * cellSize, 0, i * cellSize, Arena.HEIGHT * cellSize);
        }
        // draw line vertically.
        for (int i = 0; i <= Arena.HEIGHT; i++) {
            g.drawLine(0, i * cellSize, Arena.WIDTH * cellSize, i * cellSize);
        }

        // draw obstancles, why not let the obstancel draw itself.
        g.setColor(obsColor);
        for (Obstacle obs : arena.getObstacles()) {
            int x = (int) (obs.getX() * cellSize) + 2;
            int y = (int) (obs.getY() * cellSize) + 2;
            g.fillRect(x, y, cellSize - 4, cellSize - 4);
        }

        // draw enemies, why not let the nemies draw it self.
        g.setColor(eneColor);
        for (Enemy enemy : arena.getEnemies()) {
            int x = (int) (enemy.getX() * cellSize) + 2;
            int y = (int) (enemy.getY() * cellSize) + 2;
            g.fillOval(x, y, cellSize - 4, cellSize - 4);
        }

        // draw droid
        g.setColor(droidColor);
        Droid droid = arena.getDroid();
        int x = (int) (droid.getX() * cellSize);
        int y = (int) (droid.getY() * cellSize);
        g.fillOval(x + 2, y + 2, cellSize - 4, cellSize - 4);
        // render square on droid
        g.setColor(new Color(0.7f, 0.5f, 0f));
        g.fillRect(x + 10, y + 10, cellSize - 20, cellSize - 20);

    }

}
