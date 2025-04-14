package com.cezar.createUrl.engine;

import com.cezar.createUrl.utils.Constants;
import com.cezar.createUrl.utils.Time;

import javax.swing.JFrame;
import java.awt.*;

public class Window extends JFrame implements Runnable {

    public ML mouseListener;
    public KL keyListener;

    private static Window window = null;
    private static boolean isRunning = true;
    private Scene currentScene = null;
    private Image doubleBufferImage = null;
    private Graphics doubleBufferGraphics = null;

    public Window() {
        this.mouseListener = new ML();
        this.keyListener = new KL();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle(Constants.SCREEN_TITLE);
        this.addMouseListener(this.mouseListener);
        this.addMouseMotionListener(this.mouseListener);
        this.addKeyListener(this.keyListener);
    }

    public static Window getWindow() {
        if (Window.window == null) {
            Window.window = new Window();
        }

        return Window.window;
    }

    public void init() {
        changeScene(0);
    }

    public void changeScene(int scene) {
        switch (scene) {
            case 0:
                currentScene = new LevelEditorScene("Level Editor");
                break;
            default:
                System.out.println("Invalid scene selected");
                currentScene = null;
                break;
        }
    }

    public void update(double dt) {
        currentScene.update(dt);
        draw(getGraphics());
    }
    public void draw(Graphics g) {
        if(doubleBufferImage == null) {
            doubleBufferImage = createImage(getWidth(), getHeight());
            doubleBufferGraphics = doubleBufferImage.getGraphics();
        }

        renderOffScreen(doubleBufferGraphics);

        g.drawImage(doubleBufferImage, 0, 0, getWidth(), getHeight(), null);

    }

    public void renderOffScreen(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        currentScene.draw(g2);
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
