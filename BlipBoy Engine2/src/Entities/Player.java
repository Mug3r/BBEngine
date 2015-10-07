/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.awt.Graphics;

/**
 *
 * @author muge16
 */
public class Player {
    
    private int x, y, health;
    private boolean alive;
    
    public Player(){
    
        
    
    }    

    public static void render(Graphics brush) {
        
        
        
    }
    public void update(){
    
        
        
      if(health < 0){      
          alive = false;      
      }         
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    
}
