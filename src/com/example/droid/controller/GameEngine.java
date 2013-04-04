
package com.example.droid.controller;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.example.droid.Droids;
import com.example.droid.model.Arena;
import com.example.droid.model.Droid;
import com.example.droid.view.DroidsRenderer;

public class GameEngine {

    DPanel dPanel;
    DroidsRenderer dRenderer;
    BufferedImage screenImage = new BufferedImage(Droids.WIDTH, Droids.HEIGHT,
            BufferedImage.TYPE_INT_RGB);
    private Arena arena;
    private Controller controller;

    public GameEngine() {

        Droid droid = new Droid(Arena.WIDTH / 2, Arena.HEIGHT / 2);
        arena = new Arena(droid);
        controller = new Controller(arena);

        JFrame jFrame = new JFrame(Droids.NAME);
        // add panel to draw
        dPanel = new DPanel(screenImage);
        dPanel.addMouseListener(controller);
        dRenderer = new DroidsRenderer(arena);
        jFrame.add(dPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(Droids.WIDTH, Droids.HEIGHT);
        jFrame.setVisible(true);

    }

    public void update(float deltaTime) {
        controller.update(deltaTime);
    }

    public void render() {
        dRenderer.render(screenImage.getGraphics());
        dPanel.repaint();
    }

    public void start() {
        new Thread() {
            public void run() {

                long delta = 0l;

                while (true) {
                    long lastTime = System.nanoTime();
                    update((float) (delta / 1000000000.0));
                    render();
                    // Lock the frame rate
                    delta = System.nanoTime() - lastTime;
                    if (delta < 20000000L) {
                        try {
                            Thread.sleep((20000000L - delta) / 1000000L);
                        } catch (Exception e) {
                            // It's an interrupted exception, and nobody cares
                        }
                    }
                }
            }

        }.start();
    }

    class DPanel extends JPanel {
        private static final long serialVersionUID = -8640454741937412008L;
        BufferedImage screen;

        public DPanel(BufferedImage bufferedImage) {
            screen = bufferedImage;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D graphics2d = (Graphics2D) g;
            graphics2d.drawImage(screen, 0, 0, null);

        }
    }
}
