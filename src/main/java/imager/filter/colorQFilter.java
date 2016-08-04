package imager.filter;

import java.awt.image.BufferedImage;

public class colorQFilter extends ImgFilter {
	public colorQFilter()
	{
		super();
	}
	public colorQFilter(BufferedImage newImage){
		super(newImage);
	}
	
	@Override
	public BufferedImage filter(){
		int height = getImg().getHeight();
		int width = getImg().getWidth();
		int type = getImg().getType();
		
		BufferedImage newImage = new BufferedImage(width, height, type);
		
		
		
		return newImage;
	}
}
