package Imager_Project.imager;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

import imager.filter.BlueFilter;

public class BlueFilterTest {

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
		
		BlueFilter blue = new BlueFilter(testImg);
		
		BufferedImage blueTestImg = blue.filter();
		
	    int iRed=0;
	    int iGreen=0;
	    int iBlue=0;
	    int rgb=0;
		
		for(int x = 0; x < blueTestImg.getWidth(); x++)
		{
			for(int y = 0; y < blueTestImg.getHeight(); y++)
			{
			    iRed=0;
			    iGreen=0;
			    iBlue=0;
			    rgb=0;
			    
			    rgb = blueTestImg.getRGB(x,y);
			    iRed = rgb >>16 & 0xff;
			    iGreen = rgb>>8 & 0xff;
			    iBlue = rgb & 0xff;
			    
			    assertEquals(0,iGreen,0);
			    assertEquals(0,iRed,0);
			    assertTrue((iBlue >= 0));
			}
		}
	}

}