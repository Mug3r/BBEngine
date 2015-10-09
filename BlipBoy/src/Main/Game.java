/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyListener;
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
    
    private double averageFPS;
    
    private static final int FPS = 30;
    
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
            
            long startTime;
            long URDTime;
            long waitTime;
            long totalTime = 0;
            
            int frameCount = 0;
            int maxFrameCount = 30;
            
            long targetTime = 1000 / FPS;
            
            
                while(running){
                
            startTime = System.nanoTime();
                        
            URDTime = (System.nanoTime() - startTime) / 1000000;
            waitTime = targetTime - URDTime;
            
            
            render();
            draw();
            
            try{
            thread.sleep(waitTime);}
            catch(Exception e){
            }
            
            totalTime += System.nanoTime() - startTime;
            frameCount++;
            if(frameCount == maxFrameCount){
            averageFPS = 1000.0 / ((totalTime / frameCount)) / 1000000;
            frameCount = 0;
            totalTime = 0;
            System.out.print("step");
            }
            
            }
    }
    
    public void render(){
        
        
        g.setColor(Color.BLACK);
        g.dispose();
      
    
    }
    
     private void draw(){
            Graphics g2 = this.getGraphics();
            g2.drawImage(image, 0, 0, null);
            g2.dispose();
            
        }
    
    public void update(){}

   
}
