package Graphics;


import java.awt.image.BufferedImage;

public class spriteSheet {

	private BufferedImage sheet;
	
	public spriteSheet(BufferedImage sheet){
		this.sheet = sheet;
	}
	
	public BufferedImage crop(int col, int row, int w, int h){
		return sheet.getSubimage(col * 64, row * 64, w, h);
	}
	
}


    

