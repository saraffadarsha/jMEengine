/*
 * © Copyright DigitalByte Entertainment and Software Tech Pvt. Ltd. 2013. All rights reserved.
 * This program is licensed under GNU GPL v3.0(https://gnu.org/licenses/gpl.txt) 
 */
package org.jMEengine.controller;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;
import org.jMEengine.controller.listener.AnalogListener;

/**
 * @author Adarsha Saraff
 */
public final class Analog {

    private Sprite base, ball;
    private int ballCX, ballCY;
    private AnalogListener listener;
    private boolean valid;
    private float valX, valY;
    private int radius;

    public Analog(Image base, Image knob, int x, int y) {
        this.base = new Sprite(base);
        this.ball = new Sprite(knob);
        this.base.setPosition(x, y);
        ballCX = x + (this.base.getWidth() / 2 - this.ball.getWidth() / 2);
        ballCY = y + (this.base.getHeight() / 2 - this.ball.getHeight() / 2);
        this.ball.setPosition(ballCX, ballCY);
        valid = false;
        radius = this.base.getWidth() / 2;

    }

    public void pointerPressed(int x, int y) {
        if (x >= base.getX() && x <= (base.getX() + base.getWidth()) && y >= base.getY() && y <= (base.getY() + base.getHeight())) {
            valid = true;
        }
    }

    public void pointerDragged(int x, int y) {
        if (valid) {
            if (x > ballCX) {
                if ((x - ballCX) >= radius) {
                    valX = 1;
                    ball.setPosition(((radius + ballCX) - (ball.getWidth() / 2)), ball.getY());
                } else {
                    valX = (x - ballCX) / radius;
                    ball.setPosition(((x) - (ball.getWidth() / 2)), ball.getY());
                }
            } else {
                if ((ballCX - x) > radius) {
                    valX = -1;
                    ball.setPosition(((ballCX - radius) + (ball.getWidth() / 2)), ball.getY());
                } else {
                    valX = (ballCX - x) / radius;
                    ball.setPosition(((x) + (ball.getWidth() / 2)), ball.getY());

                }
            }
            if (y >= ballCY) {
                if ((y - ballCY) > radius) {
                    valY = 1;
                    ball.setPosition(ball.getX(), ((radius + ballCY) - (ball.getHeight() / 2)));
                } else {
                    valY = (y - ballCY) / radius;
                    ball.setPosition(ball.getX(), ((y) - (ball.getHeight() / 2)));
                }
            } else {
                if ((ballCY-y) > radius) {
                    valY = -1;
                    ball.setPosition(ball.getX(), ((ballCY-radius) + (ball.getHeight() / 2)));
                } else {
                    valY = (ballCY-y) / radius;
                    ball.setPosition(ball.getX(), ((y) + (ball.getHeight() / 2)));
                }
            }
            if (listener != null) {
                listener.onAnalogValueChanged(this, valX, valY);
            }
        }
    }

    public void pointerReleased(int x, int y) {
        valid = false;
        reset();
        if (listener != null) {
            listener.onAnalogValueChanged(this, valX, valY);
        }
    }

    public void reset() {
        valX = 0;
        valY = 0;
        valid = false;
        ball.setPosition(ballCX, ballCY);
    }

    public void setListener(AnalogListener listener) {
        this.listener = listener;
    }

    public void removeListener() {
        this.listener = null;
    }

    public void paint(Graphics g) {
        base.paint(g);
        ball.paint(g);
    }

    public void dispose() {
        ball = null;
        base = null;
        listener = null;
    }
}
