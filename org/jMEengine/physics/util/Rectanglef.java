/*
 * © Copyright DigitalByte Entertainment and Software Tech Pvt. Ltd. 2013. All rights reserved.
 * This program is licensed under GNU GPL v3.0(https://gnu.org/licenses/gpl.txt) 
 */
package org.jMEengine.physics.util;

/**
 *
 * @author Adarsha Saraff
 */
public class Rectanglef {

    public int x, y;
    public float width, height;

    public Rectanglef() {
        x = y = 0;
        width = height = 0;
    }

    public Rectanglef(int x, int y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectanglef(Rectanglef r) {
        this.x = r.x;
        this.y = r.y;
        this.width = r.width;
        this.height = r.height;
    }
}
