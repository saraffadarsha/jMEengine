/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Image;
import javax.microedition.midlet.MIDlet;
import org.jMEengine.button.SpriteButton;
import org.jMEengine.button.listener.SpriteButtonListener;
import org.jMEengine.screen.BaseScreen;
import org.jMEengine.text.Font;
import org.jMEengine.text.Text;

/**
 * @author Adarsha
 */
public class SpriteButtonMidlet extends MIDlet {
    
    public void startApp() {
        Display.getDisplay(this).setCurrent(new spritebuttontestgame());
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}

class spritebuttontestgame extends BaseScreen implements SpriteButtonListener {
    
    Font f;
    Text text;
    int score = 0;
    public void setupScreen() {
        try {
            f = new Font(Image.createImage("/chars.png"), 31, 41);
           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         text = new Text("Score-0", 5, 2, f);
        Start();
    }
    
    public void updateGame() {
        score ++;
        text.setText("Score-" + score);
    }
    
    public void draw() {
        clear(255, 255, 255);
        try {
            text.paint(g);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void dispose() {
        
    }
    
    public void onBackKeyPressed() {
        
    }
    
    public void onPress(SpriteButton button) {
        
    }
    
    public void onRelease(SpriteButton button) {
        
    }
}
