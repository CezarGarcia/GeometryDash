package com.cezar.createUrl.engine;

import com.cezar.createUrl.utils.Time;

import javax.swing.JFrame;

public class Window extends JFrame implements Runnable {

    private static Window window = null;
    private static boolean isRunning = true;

    public Window() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("Geometry Dash");
    }

    public static Window getWindow() {
        if (Window.window == null) {
            Window.window = new Window();
        }

        return Window.window;
    }

    public void init() {

    }

    public void update(double dt) {
        System.out.println(dt);
    }

    @Override
    public void run() {
        double lastFrameTime = 0.0;

        try {
            while (isRunning) {
                double time = Time.getTime();
                double deltaTime = time - lastFrameTime;
                lastFrameTime = time;

                update(deltaTime);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
