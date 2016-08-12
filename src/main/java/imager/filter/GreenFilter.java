package imager.filter;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import misc.PhotoOut;

public class GreenFilter extends ImgFilter{
	public GreenFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GreenFilter(BufferedImage newImage) {
		super(newImage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BufferedImage filter(){
		int height = getImg().getHeight();
		int width = getImg().getWidth();
		int type = getImg().getType();
		
		BufferedImage newImage = new BufferedImage(width, height, type);
		
		int rgb = 0;
		int newPixel =0;
		int greenVal = 0;
		
	    for(int i=0; i<width; i++)
	    {
	        for(int j=0; j<height; j++)
	        {
	        	newPixel = 0;
	        	rgb = 0;
	        	greenVal = 0;
	        	rgb = getImg().getRGB(i,j);
	        	newPixel = newPixel | (rgb >>8 & 0xff) <<8; 
	        	newImage.setRGB(i, j, newPixel);
	        }
	    }
	    
	    //PhotoOut out = new PhotoOut(newImage, "green");
		return newImage;
	}
}
