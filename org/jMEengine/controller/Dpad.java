/*
 * © Copyright DigitalByte Entertainment and Software Tech Pvt. Ltd. 2013. All rights reserved.
 * This program is licensed under GNU GPL v3.0(https://gnu.org/licenses/gpl.txt) 
 */
package org.jMEengine.controller;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;
import org.jMEengine.controller.listener.DpadListener;

/**
 *
 * @author Adarsha Saraff
 */
public final class Dpad {

    static final int DRELEASE = 0, DUP = -2, DDOWN = 2, DLEFT = -1, DRIGHT = 1;
    private Sprite dpad;
    private int[] seq = new int[5];
    private DpadListener listener;
    private int touchAreaWidth, touchAreaHeight;

    public Dpad(Image dpad, int frameWidth, int frameHeight, int touchAreaWidth, int touchAreaHeight) {
        this.dpad = new Sprite(dpad, frameWidth, frameHeight);
        this.touchAreaWidth = touchAreaWidth;
        this.touchAreaHeight = touchAreaHeight;
    }

    public void setFrameSequence(int release, int up, int down, int left, int right) {
        seq[0] = release;
        seq[1] = up;
        seq[2] = down;
        seq[3] = left;
        seq[4] = right;
    }

    public void paint(Graphics g) {
        dpad.paint(g);
    }

    public void pointerPressed(int x, int y) {

        if (x >= dpad.getX() && x <= (dpad.getX() + dpad.getWidth()) && y >= dpad.getY() && y <= (dpad.getY() + dpad.getHeight())) {
            int value = DRELEASE;
            if (x >= dpad.getX() && x <= (dpad.getX() + touchAreaWidth) && y >= (dpad.getY() + touchAreaHeight) && y <= (dpad.getY() + dpad.getHeight() - touchAreaHeight)) {
                value = DLEFT;
                dpad.setFrame(seq[3]);
            } else if (x >= (dpad.getX() + dpad.getWidth() - touchAreaWidth) && x <= (dpad.getX() + dpad.getWidth()) && y >= (dpad.getY() + touchAreaHeight) && y <= (dpad.getY() + dpad.getHeight() - touchAreaHeight)) {
                value = DRIGHT;
                dpad.setFrame(seq[4]);
            }
            if (y >= dpad.getY() && y <= (dpad.getY() + touchAreaHeight) && x >= (dpad.getX() + touchAreaWidth) && x <= (dpad.getX() + dpad.getWidth() - touchAreaWidth)) {
                value = DUP;
                dpad.setFrame(seq[1]);
            } else if (y >= (dpad.getY() + dpad.getHeight() - touchAreaHeight) && y <= (dpad.getY() + dpad.getHeight()) && x >= (dpad.getX() + touchAreaWidth) && x <= (dpad.getX() + dpad.getWidth() - touchAreaWidth)) {
                value = DDOWN;
                dpad.setFrame(seq[2]);
            }
            if (listener != null) {
                listener.onDpadValueChanged(this, value);
            }
        }

    }

    public void pointerReleased(int x, int y) {
        dpad.setFrame(seq[0]);
        if (x >= dpad.getX() && x <= (dpad.getX() + dpad.getWidth()) && y >= dpad.getY() && y <= (dpad.getY() + dpad.getHeight())) {
            if (listener != null) {
                listener.onDpadValueChanged(this, DRELEASE);
            }
        }
    }

    public void setListener(DpadListener listener) {
        this.listener = listener;
    }

    public void removeListener() {
        this.listener = null;
    }

    public void setTouchArea(int width, int height) {
        this.touchAreaHeight = height;
        this.touchAreaWidth = width;
    }

    public void dispose() {
        dpad = null;
        seq = null;
        listener = null;
    }

    public void setPosition(int x, int y) {
        dpad.setPosition(x, y);
    }
}
