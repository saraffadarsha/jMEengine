/*
 * © Copyright DigitalByte Entertainment and Software Tech Pvt. Ltd. 2013. All rights reserved.
 * This program is licensed under GNU GPL v3.0(https://gnu.org/licenses/gpl.txt) 
 */
package org.jMEengine.physics.util.raycast;

import javax.microedition.lcdui.game.Layer;


/**
 *
 * @author Adarsha Saraff
 */
public class RayCast {

    private Ray ray;
    private Layer layer;
    private double theta;

    public RayCast(Ray ray, Layer layer, double theta) {
        this.ray = ray;
        this.layer = layer;
        this.theta = theta;
    }

    public RayCast() {
    }

    public boolean cast() {
      
        return false;
    }

    public boolean cast(Ray ray, Layer layer, double theta) {
        this.ray = ray;
        this.layer = layer;
        this.theta = theta;
        return false;
    }
}
