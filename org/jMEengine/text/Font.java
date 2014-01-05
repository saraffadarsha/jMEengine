/*
 * © Copyright DigitalByte Entertainment and Software Tech Pvt. Ltd. 2013. All rights reserved.
 * This program is licensed under GNU GPL v3.0(https://gnu.org/licenses/gpl.txt) 
 */
package org.jMEengine.text;

import javax.microedition.lcdui.Image;

/**
 *
 * @author Adarsha Saraff
 */
public final class Font {

    private static final char[] charmap = {' ', '.', '-', '=', '+', '_', '*', '@', '#', '(', ')',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private Image image;
    private int width, height, row, col;
    private int[][] maper;

    public Font(Image resource, int frameWidth, int frameHeight) {
        this.image = resource;
        this.width = frameWidth;
        this.height = frameHeight;
        setup();
    }

    private int[] getRGBData(int x, int y) {
        int[] ARGB = new int[width * height];
        image.getRGB(ARGB, 0, width, x, y, width, height);
        return ARGB;
    }

    private void setup() {
        row = image.getHeight() / height;
        col = image.getWidth() / width;
        maper = new int[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (count < charmap.length) {
                    maper[i][j] = count;
                    count++;
                } else {
                    maper[i][j] = 0;
                }
            }
        }
    }

    public int[][] getFont(String text) {
        int[] cindex = new int[text.length()];
        int[][] argbdat = new int[text.length()][(width * height)];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            for (int j = 0; j < charmap.length; j++) {
                if (charmap[j] == ch) {
                    cindex[i] = j;
                }
            }
        }
        for (int x = 0; x < cindex.length; x++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (cindex[x] == maper[i][j]) {
                        argbdat[x] = getRGBData(j * width, i * height);
                    }
                }
            }
        }
        return argbdat;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
