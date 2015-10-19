package Main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Window {
    
    public static int width, height;
    public static Game g;
    
    public Window(String Title, int w, int h){
    
        width = w;
        height = h;
        
        g = new Game(width, height);
        
        start();
    }
    
    public static void start(){
    
        JFrame window = new JFrame();
        window.setSize(new Dimension(width, height));
        window.add(g);
        window.setTitle("Blip Boy");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        
        window.setVisible(true);
        
    
    }
    
}
