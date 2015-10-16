/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Graphics.ImageManager;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Mug3r
 */
public class Player {
    
    private BufferedImage player;
    private ImageManager im;
    private static int dir = 1;
    public static int x = 0, y = 0;
    private double health;
    private boolean running = false;
    private static boolean up = false, dn = false, lt = false, rt = false;
    
    public Player(int xco, int yco, ImageManager im){
    
        this.im = im;
        x = xco;
        y = yco;

        
    }
    
    public void update(){
    
            //Forward
                if(up){
                x += 2;
                y -= 1;}
            //Back
                else if(dn){
                y += 1;
                x -= 2;}
            //Left
                else if(lt){
                y -= 1;
                x -= 2;}
            //Right
                else if(rt){
                y += 1;
                x += 2;}
        
    }
    
    public void Render(Graphics g){
    
        g.drawImage(player, x, y, null);
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
    
    }
    
    public static void setDir(int d){dir = d;}
    
    public static void setUp(boolean u) {up = u; setDir(1);}
    public static void setDn(boolean d) {dn = d; setDir(2);}
    public static void setLt(boolean l) {lt = l; setDir(3);}
    public static void setRt(boolean r) {rt = r; setDir(4);}
    
    
}
