package filter_tests;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

import imager.filter.GreenFilter;

public class GreenFilterTest {

	@Test
	public void test() {
		String filePath = "src/main/resources/testImages/plain.jpg";
		System.out.println("filePath: "+filePath);
		BufferedImage testImg = null;
		try{
			testImg = ImageIO.read(new File(filePath));
		}
		catch (IOException e){
			System.out.println("An IO Exception was thrown");
		}
		
		GreenFilter green = new GreenFilter(testImg);
		
		BufferedImage greenTestImg = green.filter();
		
	    int iRed=0;
	    int iGreen=0;
	    int iBlue=0;
	    int rgb=0;
		
		for(int x = 0; x < greenTestImg.getWidth(); x++)
		{
			for(int y = 0; y < greenTestImg.getHeight(); y++)
			{
			    iRed=0;
			    iGreen=0;
			    iBlue=0;
			    rgb=0;
			    
			    rgb = greenTestImg.getRGB(x,y);
			    iRed = rgb >>16 & 0xff;
			    iGreen = rgb>>8 & 0xff;
			    iBlue = rgb & 0xff;
			    
			    assertEquals(0,iBlue,0);
			    assertEquals(0,iRed,0);
			    assertTrue((iGreen >= 0));
			}
		}
	}

}
