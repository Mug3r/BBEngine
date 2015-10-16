/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import Entities.Player;
import Levels.Map;
import Levels.Tiles;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author muge16
 */
public class KeyManager implements KeyListener {

   public static boolean listen = true;
    
    
    public void keyTyped(KeyEvent e) {
        
        
        
    }

   
    public void keyPressed(KeyEvent e) {
    
    if(listen){
        if(e.getKeyCode() == KeyEvent.VK_W){
            Player.setUp(true);
            }
                else if(e.getKeyCode() == KeyEvent.VK_S){
                    Player.setDn(true);
                    }
               
        if(e.getKeyCode() == KeyEvent.VK_A){
            Player.setLt(true);
            }
                else if(e.getKeyCode() == KeyEvent.VK_D){
                    Player.setRt(true);
                    }
        
        }
    }
        

   
    public void keyReleased(KeyEvent e) {
    
    if(listen){
        if(e.getKeyCode() == KeyEvent.VK_W){
            Map.setUp(false);
            Player.setUp(false);}
                else if(e.getKeyCode() == KeyEvent.VK_S){
                    Map.setDn(false);
                    Player.setDn(false);}
               
        if(e.getKeyCode() == KeyEvent.VK_A){
            Map.setLt(false);
            Player.setLt(false);}
                else if(e.getKeyCode() == KeyEvent.VK_D){
                   Map.setRt(false);
                   Player.setRt(false);}
        
    }
    
    }
    
}
