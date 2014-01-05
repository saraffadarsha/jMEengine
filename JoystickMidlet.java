/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.midlet.MIDlet;
import org.jMEengine.controller.Analog;
import org.jMEengine.controller.listener.AnalogListener;
import org.jMEengine.screen.BaseScreen;

/**
 * @author Adarsha
 */
public class JoystickMidlet extends MIDlet {

    public void startApp() {
        Display.getDisplay(this).setCurrent(new testgame());
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}

class testgame extends BaseScreen implements AnalogListener {
    
    Analog joystick;
    
    public void setupScreen() {
        try {
            joystick = new Analog(Image.createImage("/base.png"), Image.createImage("/knob.png"), 26, 150);
            joystick.setListener(this);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Start();
    }
    
    public void updateGame() {
    }
    
    public void draw() {
        clear(255, 255, 255);
        g.setColor(0, 0, 0);
        g.drawString("jMEengine Joystick Test", 20, 50, Graphics.TOP|Graphics.LEFT);
        joystick.paint(g);
    }
    
    public void dispose() {
    }
    
    public void onBackKeyPressed() {
    }
    
    public void onAnalogValueChanged(Analog controller, float valX, float valY) {
       
        System.out.println("x:"+valX);
        System.out.println("y:"+valY);
    }
    
    protected void pointerDragged(int x, int y) {
        joystick.pointerDragged(x, y);
    }
    
    protected void pointerPressed(int x, int y) {
        joystick.pointerPressed(x, y);
    }
    
    protected void pointerReleased(int x, int y) {
        joystick.pointerReleased(x, y);
    }
}

