/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import Entities.Player;
import Graphics.*;
import Levels.Map;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author muge16
 */
public class Game extends Canvas implements Runnable{
    
    private Thread thread;
    private MouseManager MM = new MouseManager();
    private KeyListener KM = new KeyManager();
    
    private boolean running;
    
    private BufferedImage image;
    private Graphics2D g;
    
    private double averageFPS;
    
    public static int width,height;
    
    private static int FPS = 60;
    private static int TPS = 60;
    private ImageLoader il;
    private ImageManager im;
    private spriteSheet ss;
    private String spriteSheetURL = "/SS2.png";
    
    private Map map;
    private String[] maps;
    private boolean bg = false;
    
    private Player player;
    
    //CONSTRUCTOR
    public Game(int w, int h) {
        super();
        setPreferredSize(new Dimension(w, h));
        setFocusable(true);
        requestFocus(); 
        
        width = w;
        height = h;
        
       /* maps = new String[5];
        maps[0] = "/maps.txt";*/
        il = new ImageLoader();        
        ss = new spriteSheet(il.loadImage(spriteSheetURL));
        im = new ImageManager(ss);
        
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
            
            map = new Map();
            map.loadMap("Res/map.txt", im);
            player = new Player(map.spawnLocation[0], map.spawnLocation[1], im);
            g = (Graphics2D) image.getGraphics();
            g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
            g.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            
            
            //Ticks and Frames per second counter
            int frames = 0;
            int ticks = 0;        
            long startTime = System.nanoTime();
            final double ns = 1000000000.0 / 60.0; 
            double delta = 0;
        
            long timer = System.currentTimeMillis();
            requestFocus();
        
            while(running){
           
           long now = System.nanoTime();
           delta += (now - startTime) / ns;
           startTime = now;
           while (delta >= 1){
               Update();
               ticks++;
               delta--;
           }           
           Render();
           frames++;
           
           if(System.currentTimeMillis() - timer > 1000){
               timer += 1000;
               
                FPS = frames;
                TPS = ticks;
               
               ticks = 0;
               frames = 0;
           }
        }
        stop();
    }
    
    
     //Draw Content
     private void Render(){
         //Setup
            BufferStrategy bs = this.getBufferStrategy();
		if(bs ==  null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
         //Background
           
            g.setColor( new Color(50, 30, 90));
            g.fillRect(0, 0, width, height);

         //Draw Here
            
            map.Render(g);
            player.Render(g);
         //End Draw
            g.dispose();
            bs.show();
        }
    
     private void Update(){
         
        player.update();
        map.update();
        
    
     }

    private synchronized void stop() {
        if(!running){return;}
        else{
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      }
        
    }
        
        
    

   
}
