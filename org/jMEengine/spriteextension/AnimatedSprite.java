/*
 * © Copyright DigitalByte Entertainment and Software Tech Pvt. Ltd. 2013. All rights reserved.
 * This program is licensed under GNU GPL v3.0(https://gnu.org/licenses/gpl.txt) 
 */
package org.jMEengine.spriteextension;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

/**
 *
 * @author Adarsha Saraff
 */
public final class AnimatedSprite extends Sprite implements Runnable {

    private Thread thread;
    private boolean loop;
    private long[] sleeptime;
    private AnimationListener listener;
    private int time;

    public AnimatedSprite(Image image, int frameWidth, int frameHeight) {
        super(image, frameWidth, frameHeight);
    }

    public void stop() {
        if(thread != null){
            loop = false;
            thread = null;
        }
        this.listener = null;
    }

    public void stop(int frameindex) {
        if(thread != null){
            loop = false;
            thread = null;
        }
        setFrame(frameindex);
        this.listener = null;
    }

    public void animate(long[] sleeptime, int[] frameseq, boolean loop) {
        stop();
        this.sleeptime = sleeptime;
        setFrameSequence(frameseq);
        this.loop = loop;
        this.listener = null;
        thread = new Thread(this);
        thread.start();
    }

    public void animate(long sleeptime, boolean loop) {
        stop();
        this.sleeptime = new long[]{sleeptime};
        this.loop = loop;
        this.listener = null;
        thread = new Thread(this);
        thread.start();
    }

    public void animate(long sleeptime, boolean loop, AnimationListener listener) {
        stop();
        this.listener = listener;
        this.sleeptime = new long[]{sleeptime};
        this.loop = loop;
        thread = new Thread(this);
        thread.start();
    }

    public void animate(long[] sleeptime, int[] frameseq, boolean loop, AnimationListener listener) {
        stop();
        this.sleeptime = sleeptime;
        setFrameSequence(frameseq);
        this.loop = loop;
        this.listener = listener;
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        time = 0;
        if(listener != null){
            listener.onAnimationStarted(this);
        }
        do {
            while (getFrame() < getFrameSequenceLength()) {
                update();
                try {
                    Thread.sleep(sleeptime[time]);
                } catch (Exception ex) {
                }
                time++;
                if (time >= sleeptime.length) {
                    time = 0;
                }
            }
            if(listener != null){
                listener.onLoopFinished(this);
            }
        } while (loop);
        if(listener != null){
            listener.onAnimationFinished(this);
        }
    }

    private void update() {
        nextFrame();
        if(listener != null){
            listener.onFrameChanged(this);
        }
    }
    
    public void dispose(){
        stop();
    }
}
