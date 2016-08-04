package imager.filter;

import java.awt.image.BufferedImage;

public abstract class ImgFilter {
	private BufferedImage img;
	
	public ImgFilter(){
		img = null;
	}
	public ImgFilter(BufferedImage newImage){
		this.img = newImage;
	}
	
	public void setImg(BufferedImage newImage){
		this.img = newImage;
	}
	public BufferedImage getImg(){
		return this.img;
	}
	
	public abstract BufferedImage filter();
}
