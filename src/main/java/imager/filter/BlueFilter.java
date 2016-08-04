package imager.filter;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BlueFilter extends ImgFilter{
	public BlueFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BlueFilter(BufferedImage newImage) {
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
		
	    for(int i=0; i<width; i++)
	    {
	        for(int j=0; j<height; j++)
	        {
	        	newPixel = 0;
	        	rgb = 0;
	        	rgb = getImg().getRGB(i,j);
	        	newPixel = newPixel | rgb & 0xff; 
	        	newImage.setRGB(i, j, newPixel);
	        }
	    }
	    
	    File outFile = new File("src/main/resources/tmp/blueImage.jpg");
	    if(outFile.exists()) { 
	        outFile.delete();
	        outFile = new File("src/main/resources/tmp/blueImage.jpg");
	    }
	    try {
			ImageIO.write(newImage, "jpg", outFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newImage;
	}
}
