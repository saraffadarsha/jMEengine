/*
 * © Copyright DigitalByte Entertainment and Software Tech Pvt. Ltd. 2013. All rights reserved.
 * This program is licensed under GNU GPL v3.0(https://gnu.org/licenses/gpl.txt) 
 */
package org.jMEengine.spriteextension;

/**
 *
 * @author Adarsha Saraff
 */
public interface AnimationListener {
    public void onAnimationStarted(AnimatedSprite animatedsprite);
    public void onFrameChanged(AnimatedSprite animatedsprite);
    public void onLoopFinished(AnimatedSprite animatedsprite);
    public void onAnimationFinished(AnimatedSprite animatedsprite);
}
