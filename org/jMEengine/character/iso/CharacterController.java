/*
 * © Copyright DigitalByte Entertainment and Software Tech Pvt. Ltd. 2013. All rights reserved.
 * This program is licensed under GNU GPL v3.0(https://gnu.org/licenses/gpl.txt) 
 */
package org.jMEengine.character.iso;

import javax.microedition.lcdui.game.Sprite;
import javax.microedition.lcdui.game.TiledLayer;

/**
 *
 * @author Adarsha Saraff
 */
public final class CharacterController {

    public static final int FORWARD = 1, BACKWARD = -1, LEFT = -2, RIGHT = 2;
    
    Sprite character;
    public TiledLayer wall;
    public int hspeed = 2;
    public int vspeed = 2;
    
    public CharacterController(Sprite character, TiledLayer wall, int hspeed, int vspeed){
        this.character = character;
        this.wall = wall;
        this.hspeed = hspeed;
        this.vspeed = vspeed;
    }
    
    public void move(int direction){
        switch(direction){
            case FORWARD:
                character.move(0, -vspeed);
                if(wall != null){
                    if(character.collidesWith(wall, true)){
                        character.move(0, vspeed);
                    }
                }
                break;
            case BACKWARD:
                character.move(0, vspeed);
                if(wall != null){
                    if(character.collidesWith(wall, true)){
                        character.move(0, -vspeed);
                    }
                }
                break;
            case LEFT:
                character.move(-hspeed, 0);
                if(wall != null){
                    if(character.collidesWith(wall, true)){
                        character.move(hspeed, 0);
                    }
                }
                break;
            case RIGHT:
                character.move(hspeed, 0);
                if(wall != null){
                    if(character.collidesWith(wall, true)){
                        character.move(-hspeed, 0);
                    }
                }
                break;
        } 
    }
    
}
