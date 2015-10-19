package Levels;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Lights {
    
    private BufferedImage image;
    private AlphaComposite ac;
	
    private int x;
    private int y;
    private int radius;
    private int luminosity;

    
    public Lights(int i1, int i2, int i3, int i4){

        x = i1;
	y = i2;
	radius = i3;
	luminosity = i4;
		
	image = new BufferedImage(radius * 2, radius * 2, BufferedImage.TYPE_INT_ARGB);
	Graphics2D g2 = (Graphics2D) image.getGraphics();
		
	// i draw multiple circles here to simulate gradient alpha
	// better is to just use gradient paint
	int step = 8;
	int numSteps = radius / step;
	g2.setColor(new Color(0, 0, 0, luminosity));
	for(int i = 0; i < numSteps; i++) {
            g2.fillOval(radius - i * step, radius - i * step, i * step * 2, i * step * 2);

        }
    
    }
}
