package com.cezar.createUrl;

import com.cezar.createUrl.engine.Window;

public class Main {
    public static void main(String[] args) {
        Window window = Window.getWindow();
        window.init();

        Thread mainThread = new Thread(window);
        mainThread.start();
    }
}