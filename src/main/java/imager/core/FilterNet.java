package imager.core;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import imager.filter.*;

public class FilterNet {
	BufferedImage img = null;
	
	public FilterNet(){
		img = null;
	}
	public FilterNet(BufferedImage image){
		img = image;
	}

	public BufferedImage getImg(){
		return img;
	}
	public void setImg(BufferedImage img) {
		this.img = img;
	}
	


	public HashMap<String, BufferedImage> filter(){
		HashMap<String, BufferedImage> hmap = new HashMap<String, BufferedImage>();

		BufferedImage low = new LowResFilter(img).filter();

		hmap.put("lowImg", low);
		hmap.put("blueImg", new BlueFilter(low).filter());
		hmap.put("greenImg", new GreenFilter(low).filter());
		hmap.put("redImg", new RedFilter(low).filter());
		
		return hmap;
	}
}
