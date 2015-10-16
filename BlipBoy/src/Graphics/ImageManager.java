/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import java.awt.image.BufferedImage;

/**
 *
 * @author Mug3r
 */
public class ImageManager {
    
    public BufferedImage[] player = new BufferedImage[4];
    public BufferedImage[] flats = new BufferedImage[3];
    public BufferedImage[] slopes = new BufferedImage[4];
    public BufferedImage[] Eslopes = new BufferedImage[4];
    public BufferedImage empty;
    
    private int width = 64, height = 64;
    
    public  ImageManager(spriteSheet ss){
    
        for(int i = 0; i < player.length; i++){
            
            player[i] = ss.crop(6+i, 0, 18, 35);
        
        }
        for(int j = 0; j < flats.length; j++){
            if(j < 2){
            flats[j] = ss.crop(0+j, 0, width, height);}
            else
            flats[j] = ss.crop(1, 1, width, height);
        
        }
        for(int k = 0; k < slopes.length; k++){
      
                
            slopes[k] = ss.crop(2+k, 0, width, height);
            
            
        
        }
        for(int l = 0; l < Eslopes.length; l++){
        
            Eslopes[l] = ss.crop(2+l, 1, width, height);
        
        }
        empty = ss.crop(0, 1, width, height);
    
    }

}
    