/*
 * © Copyright DigitalByte Entertainment and Software Tech Pvt. Ltd. 2013. All rights reserved.
 * This program is licensed under GNU GPL v3.0(https://gnu.org/licenses/gpl.txt) 
 */
package org.jMEengine.physics.util.raycast;

/**
 *
 * @author Adarsha Saraff
 */
public final class Ray {
    public static final int INFINITE = 1000;
    
    private int x, y;
    private int distance;
    
    public Ray(int x, int y, int distance){
        this.x = x;
        this.y = y;
    }
    
    public void setOrigin(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int[] getOrigin(){
        return new int[]{this.x,this.y};
    }
    
    public int getDistance(){
        return this.distance;
    }
    
    public void setDistance(int distance){
        this.distance = distance;
    }
}
