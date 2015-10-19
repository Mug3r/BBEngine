package Graphics;

import Entities.Player;
import Levels.Map;
import Main.Boot;
import Main.KeyManager;

public class Camera {
    
    public static int x, y;
    public boolean up = false,dn = false,lt = false,rt = false;
    private int shiftsx = 0, shiftsy = 0;
    
    public Camera(int xc, int yc){
    
       x = xc;
       y = yc;
        
    }
    
    public void update(){
        
        if(Player.x < x && Player.y < y){        
            lt = true;
            x = Player.x;
            y = Player.y;
        } else {lt = false;}
        
        if(Player.x > x && Player.y > y){        
            rt = true;
            x = Player.x;
            y = Player.y;
        } else {rt = false;}
        
        if(Player.x > x && Player.y < y){
            up = true;
            y = Player.y;
            x = Player.x;
        } else {up  = false;}
        
        if(Player.x < x && Player.y > y){
            dn = true;
            y = Player.y;
            x = Player.x;
        } else { dn = false;}
        
    }
    
    public static void moveCamera(int xc, int yc){
    
        
            
    }
    
}
