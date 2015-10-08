/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author muge16
 */
public class Game extends JPanel implements Runnable{
    
    private Thread thread;
    private MouseManager MM = new MouseManager();
    private KeyListener KM = new KeyManager();
    
    private boolean running;
    
    private BufferedImage image;
    private Graphics2D g;
    
    
    //CONSTRUCTOR
    public Game(int w, int h) {
        super();
        setPreferredSize(new Dimension(w, h));
        setFocusable(true);
        requestFocus();       
        
       }
    
    //METHODS
    public void addNotify(){
        super.addNotify();
        
        if(thread == null){
        thread = new Thread(this);
        thread.start();
        }
        addKeyListener(KM);
        addMouseListener(MM);
    }

  
    public void run() {
            
            running = true;
            
            image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
            g = (Graphics2D) image.getGraphics();
            g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
            g.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            ;
    }

   
}
