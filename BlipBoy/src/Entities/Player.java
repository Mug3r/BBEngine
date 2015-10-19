package Entities;

import Graphics.ImageManager;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Player {
    
    public BufferedImage player;
    
    
    private ImageManager im;
    public static int dir = 1;
    public static int x = 0, y = 0, h = 0;
    private double health;
    private boolean running = false;
    private static boolean up = false, dn = false, lt = false, rt = false;
    public static boolean collidedx = false, collidedy = false;
    
    public Player(int xco, int yco, ImageManager im){
    
        this.im = im;
        x = xco;
        y = yco;
        
        
    }
    
    public void update(){
        
        
        
            //Forward
                if(up){
                if(!collidedx){x += 2;}
                if(!collidedy){y -= 1;}
                }
            //Back
                else if(dn){
                if(!collidedy){y += 1;}
                if(!collidedx){x -= 2;}
                
                }
        
                
       
            //Left
                if(!up && !dn && lt){
                if(!collidedy){y -= 1;}
                if(!collidedx){x -= 2;}
                }
            //Right
                else if(!up && !dn && rt){
                if(!collidedy){y += 1;}
                if(!collidedx){x += 2;}}
        
                
                
        
    }
    
    public void Render(Graphics g){
        
        
        switch (dir){
            //Void
            case 0:
                player = im.empty;
                break;
            //Forward
            case 1:
                player = im.player[0];
                break;
            //Back
            case 2:
                player = im.player[1];
                break;
            //Left
            case 3:
                player = im.player[2];
                break;
            //Right
            case 4:
                player = im.player[3];
                break;
        }
        
        g.drawImage(player, x, y, null);
        
    
    }
    
    
    
    public static void setDir(int d){dir = d;}
    
    public static void setUp(boolean u) {up = u; setDir(1);}
    public static void setDn(boolean d) {dn = d; setDir(2);}
    public static void setLt(boolean l) {lt = l; setDir(3);}
    public static void setRt(boolean r) {rt = r; setDir(4);}
  

    public static boolean isUp() {return up;}
    public static boolean isDn() {return dn;}
    public static boolean isLt() {return lt;}
    public static boolean isRt() {return rt;}   
    
    
}
