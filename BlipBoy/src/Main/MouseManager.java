/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author muge16
 */
public class MouseManager implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
System.out.println("click");    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Pressed");
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
