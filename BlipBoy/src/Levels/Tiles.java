/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Levels;

import Entities.Player;
import Graphics.ImageManager;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author muge16
 */
public class Tiles {
    
    private int x, y;
    private boolean up = false, dn = false, lt = false, rt = false, walkable = false;
    private int speed = 1;
    private BufferedImage tile;
    
    
    
    public Tiles(int tN, int xco, int yco, int type, ImageManager im){
    
        x = xco;
        y = yco;
        
        switch (type){
            
            case 0:
               tile = im.empty;
               walkable = false;
               break;
            case 1:
               tile = im.flats[0];
               walkable = true;
               break;
            case 2:
               tile = im.flats[1];
               walkable = true;
               break;
            case 3:
               tile = im.flats[2];
               break;
            case 4:
               tile = im.slopes[0];
               break;
            case 5:   
               tile = im.slopes[1];
               break;
            case 6:
               tile = im.slopes[2];
                break;
            case 7:
               tile = im.slopes[3];
            case 8:
               tile = im.Eslopes[0];
            case 9:
               tile = im.Eslopes[1];
                break;
            case 10:
               tile = im.Eslopes[2];
               break;
            case 11:
               tile = im.Eslopes[3];
               break;
        }
        
        
    }

    public void Update() {
        
       if(up){
           
           y += 3;
           x -= 6;
           
       
       }else if(dn){
       
           y -= 3;
           x += 6;
           
       }
       
       if(lt){
       
           y += 3;
           x += 6;
       
       }else if(rt){
       
           y -= 3;
           x -= 6;
           
       }
        
    }
                
        
    
    
    public void Render(Graphics g){
    
        g.drawImage(tile, x, y, null);
    
    }

    public void setUp(boolean u) {up = u;}
    public void setDn(boolean d) {dn = d;}
    public void setLt(boolean l) {lt = l;}
    public void setRt(boolean r) {rt = r;}

    public void setSpeed(int s) {speed = s;}

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
    
    
    
}
