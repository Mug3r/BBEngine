/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Levels;

/**
 *
 * @author muge16
 */
public class Tiles {
    
    private int x, y;
    private boolean up = false, dn = false, lt = false, rt = false;
    private int speed;
    
    
    public Tiles(int tN, int xco, int yco, int type){
    
        x = xco;
        y = yco;
        
        
    }

    public void Update() {
        
       if(up){
           
           y -= speed;
       
       }else if(dn){
       
           y += speed;
           
       }
       
       if(lt){
       
           x -= speed;
       
       }else if(rt){
       
           x += speed;
           
       }
        
    }
                
        
    
    
    public void Render(){
    
        
    
    }

    public void setUp(boolean u) {up = u;}
    public void setDn(boolean d) {dn = d;}
    public void setLt(boolean l) {lt = l;}
    public void setRt(boolean r) {rt = r;}

    public void setSpeed(int s) {speed = s;}
    
    
    
}
