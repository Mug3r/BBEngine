package Main;

import Graphics.Camera;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseManager implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
    
        if(e.getButton() == MouseEvent.BUTTON2){
            Camera.moveCamera(e.getX(), e.getY());
        }    
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Pressed");
        if(e.getButton() == MouseEvent.BUTTON3){
            Camera.moveCamera(e.getX(), e.getY());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
System.out.println("Mouse In");    }

    @Override
    public void mouseExited(MouseEvent e) {
System.out.println("Mouse Out");
        }
    
}
