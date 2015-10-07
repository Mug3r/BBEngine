/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Display;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author muge16
 */
public class Frame {
    
    private Screen screen;
    
    public void createWindow(String Title, int Width, int Height){
    
        JFrame window = new JFrame();
        window.setTitle(Title);
        window.setSize(new Dimension(Width, Height));        
        window.setContentPane(screen);
        window.pack();
    
    }
    
}
