package imager.filter;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import imager.core.PhotoOut;

public class LowResFilter extends ImgFilter{

	public LowResFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LowResFilter(BufferedImage newImage) {
		super(newImage);
		// TODO Auto-generated constructor stub
	}
	
	//default filter which scales the img to a tenth of its original size
	public BufferedImage filter(){
		int sHeight = getImg().getHeight()/10;
		int sWidth = getImg().getWidth()/10;
		
		BufferedImage newImg = new BufferedImage(sWidth, sHeight, getImg().getType());
		Graphics2D graph = newImg.createGraphics();
		graph.drawImage(getImg(), 0, 0, sWidth, sHeight, null);
		
		graph.dispose();
		PhotoOut out = new PhotoOut(newImg, "lowRes");
		return newImg;
	}
	public BufferedImage filter(int scale){
		int sHeight = getImg().getHeight()/scale;
		int sWidth = getImg().getWidth()/scale;
		
		BufferedImage newImg = new BufferedImage(sWidth, sHeight, getImg().getType());
		Graphics2D graph = newImg.createGraphics();
		graph.drawImage(getImg(), 0, 0, sWidth, sHeight, null);
		
		graph.dispose();
		
		PhotoOut out = new PhotoOut(newImg, "lowRes");
		return newImg;
	}
}
