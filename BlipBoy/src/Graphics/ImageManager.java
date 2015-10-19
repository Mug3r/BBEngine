
package Graphics;

import java.awt.image.BufferedImage;


public class ImageManager {
    
    public BufferedImage[] player = new BufferedImage[4];
    public BufferedImage[] flats = new BufferedImage[3];
    public BufferedImage[] slopes = new BufferedImage[4];
    public BufferedImage[] Eslopes = new BufferedImage[4];
    public BufferedImage[] Bullets = new BufferedImage[2];
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
        for(int m = 0; m < Bullets.length; m++){
        
            Bullets[m] = ss.crop(6+m, 1, 6, 4);
        
        }
        empty = ss.crop(0, 1, width, height);
    
    }

}
    