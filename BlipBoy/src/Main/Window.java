/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author muge16
 */
public class Window {
    
    public static int width, height;
    
    public Window(String Title, int w, int h, JPanel Content){
    
        width = w;
        height = h;
        
        JFrame window = new JFrame();
        window.setSize(new Dimension(width, height));
        window.setContentPane(Content);
        window.setTitle(Title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setBackground(Color.black);
        window.setVisible(true);
        
    
    }
    
}
