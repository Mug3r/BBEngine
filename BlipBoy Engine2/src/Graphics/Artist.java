/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Graphics;

import Entities.Enemies;
import Entities.Player;
import Map.Map;
import java.awt.Graphics;

/**
 *
 * @author muge16
 */
public class Artist {
    
    private static Graphics brush;
    
    public Artist(){
   
        
    }
    
    public static void Render(){
    
        Map.render(brush);
        Player.render(brush);
        Enemies.render(brush);
    
    }

    public void setBrush(Graphics brush) {
        this.brush = brush;
    }

}
