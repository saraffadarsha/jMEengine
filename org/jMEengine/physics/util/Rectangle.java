/*
 * © Copyright DigitalByte Entertainment and Software Tech Pvt. Ltd. 2013. All rights reserved.
 * This program is licensed under GNU GPL v3.0(https://gnu.org/licenses/gpl.txt) 
 */
package org.jMEengine.physics.util;

/**
 *
 * @author Adarsha Saraff
 */
public class Rectangle {

    public int x, y;
    public int width, height;

    public Rectangle() {
        x = y = width = height = 0;
    }
    
    public Rectangle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public Rectangle(Rectangle r){
        this.x = r.x;
        this.y = r.y;
        this.width = r.width;
        this.height = r.height;
    }
}
