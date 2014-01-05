/*
 * © Copyright DigitalByte Entertainment and Software Tech Pvt. Ltd. 2013. All rights reserved.
 * This program is licensed under GNU GPL v3.0(https://gnu.org/licenses/gpl.txt) 
 */
package org.jMEengine.text;

import javax.microedition.lcdui.Graphics;

/**
 *
 * @author Adarsha Saraff
 */
public final class Text {

    private String text;
    private int x, y;
    private Font f;
    int[][] rgbData;

    public Text(String text, int x, int y, Font font) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.f = font;
        rgbData = f.getFont(text);
    }

    public void setText(String text) {
        this.text = text;
        rgbData = f.getFont(text);
    }

    public void paint(Graphics g) {
        for (int i = 0; i < rgbData.length; i++) {
            g.drawRGB(rgbData[i], 0, f.getWidth(), x + (i * f.getWidth()), y, f.getWidth(), f.getHeight(), true);
        }
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String getText() {
        return this.text;
    }
}
