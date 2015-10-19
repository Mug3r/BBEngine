package Main;

import Entities.Player;
import Graphics.Camera;
import Levels.Map;
import Levels.Tiles;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyManager implements KeyListener {

   public static boolean listen = true;
   private static int dir = 1;
    
    
    public void keyTyped(KeyEvent e) {
        
        
        
    }

   
    public void keyPressed(KeyEvent e) {
    
        if(e.getKeyCode() == KeyEvent.VK_W){
            dir = 1;
            Player.setUp(true);
            }
                else if(e.getKeyCode() == KeyEvent.VK_S){
                    dir = 2;
                    Player.setDn(true);
                  
                    }
               
        if(e.getKeyCode() == KeyEvent.VK_A){
            dir = 3;
            Player.setLt(true);
            }
                else if(e.getKeyCode() == KeyEvent.VK_D){
                    dir = 4;
                    Player.setRt(true);
                    }
        
        
        
    }
        

   
    public void keyReleased(KeyEvent e) {
    
        if(e.getKeyCode() == KeyEvent.VK_W){
            Player.setUp(false);
            }
                else if(e.getKeyCode() == KeyEvent.VK_S){
                    Player.setDn(false);                   
                    }
        if(e.getKeyCode() == KeyEvent.VK_A){
            Player.setLt(false);
            }
                else if(e.getKeyCode() == KeyEvent.VK_D){
                    Player.setRt(false);
                    }
        

    }
    
    public static void update(){
    
        Player.setDir(dir);
    
    }
    
}
