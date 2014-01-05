/*
 * © Copyright DigitalByte Entertainment and Software Tech Pvt. Ltd. 2013. All rights reserved.
 * This program is licensed under GNU GPL v3.0(https://gnu.org/licenses/gpl.txt) 
 */
package org.jMEengine.character.platform2d;

import javax.microedition.lcdui.game.Sprite;
import javax.microedition.lcdui.game.TiledLayer;

/**
 *
 * @author Adarsha Saraff
 */
public final class CharacterController {

    public static final int FORWARD = 1, BACKWARD = -1;
    public Sprite character;
    public TiledLayer ground;
    public TiledLayer wall;
    public int hspeed = 2;
    public int vspeed = 2;
    public int jumpStep = 6;
    public int gravity = 1;
    private boolean jumping = false;
    private boolean grounded = false;
    private int stepcount = 0;
    
    public CharacterController(Sprite character, TiledLayer ground, TiledLayer wall, int hspeed, int vspeed, int jumpstep, int gravity){
        this.character = character;
        this.gravity = gravity;
        this.hspeed = hspeed;
        this.vspeed = vspeed;
        this.jumpStep = jumpstep;
        this.wall = wall;
        this.ground = ground;
    }

    public void update() {
        if (jumping) {
            if (stepcount < jumpStep) {
                character.move(0, -vspeed);
                stepcount++;
                if (ground != null) {
                    if (character.collidesWith(ground, true)) {
                        character.move(0, vspeed);
                    }
                }
            } else {
                jumping = false;
            }
        } else {
            character.move(0, gravity);
            if (ground != null) {
                if (character.collidesWith(ground, true)) {
                    character.move(0, -gravity);
                    grounded = true;
                } else {
                    grounded = false;
                }
            }
        }
    }

    public boolean isGrounded() {
        return grounded;
    }

    public void move(int direction) {
        character.move(hspeed * direction, 0);
        if (wall != null) {
            if (character.collidesWith(wall, true)) {
                character.move(-hspeed * direction, 0);
            }
        }
    }

    public void jump() {
        if (grounded) {
            jumping = true;
            grounded = false;
            stepcount = 0;
        }
    }
}
