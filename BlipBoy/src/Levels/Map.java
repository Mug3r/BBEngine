/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Levels;

import Entities.Player;
import Graphics.Camera;
import Graphics.ImageManager;
import Main.Game;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author muge16
 */
public class Map {
    
    public static Tiles[] tiles = new Tiles[1483];
    private static int tileSize = 64;
    private static int step = 0;
    private static int stepX = 0;
    private static int stepY = 0;
    private static int tileNumber = 0;
    private static boolean mapLoaded = false;
    private static boolean mapCleared = false;
    private static int map = 1;
    private static String[] path;
    
    private static Camera camera;
    
    public static int[] spawnLocation = new int[2];;
    private static boolean spawnSet = false;
    
    private static boolean up = false, dn = false, lt = false, rt = false;

    
    
    public Map(){

        
        
    }
    
    public static void loadMap(String path, ImageManager im){
            stepX = 0;
            stepY = 0;
            int row = 0;
            tileNumber = 0;
        try {
            
            File map = new File(path);
            Scanner f = new Scanner(map);
            while (f.hasNext()){
                
                
                String line = f.nextLine();
                Scanner s = new Scanner(line).useDelimiter("#");
                while(s.hasNext()){
                    
                    if(!spawnSet){spawnLocation[0] = s.nextInt();
                                  spawnLocation[1] = s.nextInt();
                                  spawnSet = true;
                                  camera = new Camera();}
                    else{
                    
                    int tileX = ((stepX)*63 - 32*row) + 1000;               
                    int tileY = ((stepY)*63 - (47*(stepY))) - 250;
                    
                   int tileType = s.nextInt();
                    
                    tiles[tileNumber] = new Tiles(tileNumber,tileX, tileY, tileType, im);
                    stepX++;
                    tileNumber++;
                    }
                    
                }
                stepY++;
                row++;
                stepX = 0;
                
                
            }
            
            stepY = 0;
            
            mapLoaded = true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static void update(){
        

      /*  
        if(mapCleared){
            
            mapLoaded = false; 
            mapCleared = false;
            
        }
        
        if(!mapLoaded){
        
            loadMap(path[map]);
            mapLoaded = true;
            
        } */
        
        
        camera.update();
        
        for(int i = 0; i < tiles.length; i++){
        
            tiles[i].Update();
            tiles[i].setDn(camera.dn);
            tiles[i].setUp(camera.up);
            tiles[i].setLt(camera.lt);
            tiles[i].setRt(camera.rt);
            
        }
        
    }
    
    public static void Render(Graphics g){
    
        if(mapLoaded){
       for(int i = 0; i < tiles.length -1; i++){
        
            tiles[i].Render(g);
            
        } }
        else {System.out.print("no Map");}
       
        
    }

    public static void setMapCleared(boolean mapCleared) {
        Map.mapCleared = mapCleared;
    }
    
    public static void setMap(int m){    
        map = m;    
    }

    public static void setUp(boolean up) {
        Map.up = up;
    }

    public static void setDn(boolean dn) {
        Map.dn = dn;
    }

    public static void setLt(boolean lt) {
        Map.lt = lt;
    }

    public static void setRt(boolean rt) {
        Map.rt = rt;
    }

    public static Tiles[] getTiles() {
        return tiles;
    }
    
    
    
    
    
}
