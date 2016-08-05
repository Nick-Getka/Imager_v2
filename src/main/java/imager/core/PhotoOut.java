package imager.core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PhotoOut {
	public PhotoOut(BufferedImage out, String fName){
		 File outFile = new File("src/main/resources/tmp/"+fName+".jpg");
		    if(outFile.exists()) { 
		        outFile.delete();
		        outFile = new File("src/main/resources/tmp/"+fName+".jpg");
		    }
		    try {
				ImageIO.write(out, "jpg", outFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
