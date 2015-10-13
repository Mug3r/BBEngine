/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Levels;

import java.awt.*;
import java.util.Scanner;

/**
 *
 * @author muge16
 */
public class Map {
    
    private static Tiles[] tiles = new Tiles[140];
    private static int tileSize = 64;
    private static int size = 0;
    private static int shift = 14;
    private static int step = 0;
    private static int stepX = 0;
    private static int stepY = 0;
    
    
    public Map(String path){
    
        loadMap(path);
        
    }
    
    public static void loadMap(String path){
    
        Scanner f = new Scanner(path);
            while (f.hasNext()){
            
                
                String line = f.nextLine();
                Scanner s = new Scanner(line).useDelimiter("#");
                int tileNumber = s.nextInt();
                int tileX = (stepX+step)*64;
                int tileY = (stepY+step)*64;
                int tileType = s.nextInt();
                tiles[size] = new Tiles(tileNumber, tileX, tileY, tileType);
                if(size > shift){                
                    step++;
                    shift += 14;
                    stepX = 0;
                }
                stepX++;
                size++;
                
            }
    
    }
    
    public static void update(){
    
        
        
    }
    
    public static void Render(Graphics2D g){
    
        
        
    }
    
}
