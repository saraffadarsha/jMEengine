/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.midlet.MIDlet;
import org.jMEengine.controller.Dpad;
import org.jMEengine.controller.listener.DpadListener;
import org.jMEengine.screen.BaseScreen;

/**
 * @author Adarsha
 */
public class DpadMidlet extends MIDlet {
    
    public void startApp() {
        Display.getDisplay(this).setCurrent(new dpadtest());
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}

class dpadtest extends BaseScreen implements DpadListener {
    
    Dpad pad;

    public void setupScreen() {
        try {
            pad = new Dpad(Image.createImage("/keypad.png"), 75, 75, 23, 25);
            pad.setListener(this);
            pad.setPosition(15, 150);
            pad.setFrameSequence(0, 2, 4, 3, 1);
        } catch (Exception ex) {
        }
        Start();
    }
    
    public void updateGame() {
        
    }
    
    public void draw() {
        clear(255, 255, 255);
        g.setColor(0, 0, 0);
        g.drawString("jMEengine keypad test", 20, 50, Graphics.TOP|Graphics.LEFT);
        pad.paint(g);
    }
    
    protected void pointerDragged(int x, int y) {
        
    }
    
    protected void pointerPressed(int x, int y) {
        pad.pointerPressed(x, y);
    }
    
    protected void pointerReleased(int x, int y) {
        pad.pointerReleased(x, y);
    }
    
    public void dispose() {
        
    }
    
    public void onBackKeyPressed() {
        
    }
    
    public void onDpadValueChanged(Dpad dpad, int value) {
        System.out.println(value);
    }
}
