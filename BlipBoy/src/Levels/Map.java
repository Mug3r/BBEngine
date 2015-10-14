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
    private static int step = 0;
    private static int stepX = 0;
    private static int stepY = 0;
    private static int tileNumber = 0;
    private static boolean mapLoaded = false;
    private static boolean mapCleared = false;
    private static int map = 1;
    private static String[] path;
    
    
    public Map(String[] path){
    
        this.path = path;
        
    }
    
    public static void loadMap(String path){
    
        stepX = 0;
        stepY = 0;
        tileNumber = 0;
        
        Scanner f = new Scanner(path);
            while (f.hasNext()){
            
                
                String line = f.nextLine();
                Scanner s = new Scanner(line).useDelimiter("#");
                while(s.hasNext()){
                
                int tileX = (stepX)*64;
                int tileY = (stepY)*64;
                int tileType = s.nextInt();
                tiles[tileNumber] = new Tiles(tileNumber,tileX, tileY, tileType);
                stepX++;
                tileNumber++;
                
                }
                stepY++;
                stepX = 0;

                
            }
            
            stepY = 0;
    
    }
    
    public static void update(){
        

        
        if(mapCleared){
            
            mapLoaded = false; 
            mapCleared = false;
            
        }
        
        while(!mapLoaded){
        
            loadMap(path[map]);
            mapLoaded = true;
            
        }
        
    
        for(int i = 0; i < tiles.length; i++){
        
            tiles[i].Update();
            
        }
        
    }
    
    public static void Render(Graphics2D g){
    
       for(int i = 0; i < tiles.length; i++){
        
            tiles[i].Render();
            
        } 
        
    }

    public static void setMapCleared(boolean mapCleared) {
        Map.mapCleared = mapCleared;
    }
    
    public static void setMap(int m){    
        map = m;    
    }
    
    
}
