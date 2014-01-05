/*
 * © Copyright DigitalByte Entertainment and Software Tech Pvt. Ltd. 2013. All rights reserved.
 * This program is licensed under GNU GPL v3.0(https://gnu.org/licenses/gpl.txt) 
 */
package org.jMEengine.button;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;
import org.jMEengine.button.listener.SpriteButtonListener;

/**
 *
 * @author Adarsha Saraff
 */
public final class SpriteButton extends Sprite{

    private SpriteButtonListener listener;
 
    
    public SpriteButton(Image image, int frameWidth, int frameHeight) {
        super(image, frameWidth, frameHeight);
    }

    
    public void PointerPressed(int x, int y){
         if(x>=getX() && x <= (getX()+getWidth()) && y >= getY() && y <= (getY()+getHeight())){
             setFrame(1);
             if(listener != null){
                 listener.onPress(this);
             }
         }
    }
    
    public void PointerReleased(int x, int y){
        if(x>=getX() && x <= (getX()+getWidth()) && y >= getY() && y <= (getY()+getHeight())){
             setFrame(0);
             if(listener != null){
                 listener.onRelease(this);
             }
         }
    }
    
    public void setListener(SpriteButtonListener listener){
        this.listener = listener;
    }
    
    public void removeListener(){
        this.listener = null;
    }
}
