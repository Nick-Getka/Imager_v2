package imager.core;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import imager.pro.RGBPro;

public class ProNet {
	HashMap<String, BufferedImage> imgMap = new HashMap<String, BufferedImage>();
	HashMap<String, Double> imgData = new HashMap<String, Double>();
	boolean preFilter = false;

	public ProNet(HashMap<String, BufferedImage> img) {
		super();
		this.imgMap = img;
		
	}
	
	public HashMap<String, Double> getImgData() {
		return imgData;
	}

	public HashMap<String, Double> pro(){
		RGBPro rgb = new RGBPro(imgMap.get("lowImg"));
		imgData.put("blue", rgb.getBluePerc() );
		imgData.put("green", rgb.getGreenPerc());
		imgData.put("red", rgb.getRedPerc());	
		
		return imgData;
	}
	
	
	
}
