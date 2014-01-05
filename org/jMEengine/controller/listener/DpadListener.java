/*
 * © Copyright DigitalByte Entertainment and Software Tech Pvt. Ltd. 2013. All rights reserved.
 * This program is licensed under GNU GPL v3.0(https://gnu.org/licenses/gpl.txt) 
 */
package org.jMEengine.controller.listener;

import org.jMEengine.controller.Dpad;

/**
 *
 * @author Adarsha Saraff
 */
public interface DpadListener {
    public void onDpadValueChanged(Dpad dpad, int value);
}
