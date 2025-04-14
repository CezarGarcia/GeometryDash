package com.cezar.createUrl.engine;

import com.cezar.createUrl.utils.Constants;

import java.awt.*;

public class LevelEditorScene extends Scene{

    public LevelEditorScene(String name) {
        super.Scene(name);
    }

    @Override
    public void init() {

    }

    @Override
    public void update(double dt) {
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.BLUE);
        g2.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
    }
}
