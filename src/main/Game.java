package main;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable {

    static final long serialVersionUID = 1L;

    boolean isRunning = false;
    Thread thread;

    public Game() {
        new Windows(800, 600, "Purple Square", this);
        run();
    }

    @Override
    public void run() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    

    public static void main(String[] args) {
        new Game();
    }
}
