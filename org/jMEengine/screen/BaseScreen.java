/*
 * © Copyright DigitalByte Entertainment and Software Tech Pvt. Ltd. 2013. All rights reserved.
 * This program is licensed under GNU GPL v3.0(https://gnu.org/licenses/gpl.txt) 
 */
package org.jMEengine.screen;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;

/**
 *
 * @author Adarsha Saraff
 */
public abstract class BaseScreen extends GameCanvas implements Runnable {

    protected Graphics g;
    private Thread thread;
    private boolean run;
    protected long SleepTime = 60;

    public abstract void setupScreen();

    public abstract void updateGame();

    public abstract void draw();

    public abstract void dispose();

    public abstract void onBackKeyPressed();

    public BaseScreen() {
        super(true);
        g = getGraphics();
        setFullScreenMode(true);
        thread = new Thread(this);
        setupScreen();
    }

    public void clear(int color) {
        g.setColor(color);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    public void clear(int R, int G, int B) {
        g.setColor(R, G, B);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    public void Start() {
        run = true;
        thread.start();
    }

    public void Stop() {
        run = false;
        thread = null;
    }

    public void run() {
        while (run) {
            try {
                updateGame();
                draw();
                flushGraphics();
                Thread.sleep(SleepTime);
            } catch (Exception ex) {
            }
        }
    }
}
