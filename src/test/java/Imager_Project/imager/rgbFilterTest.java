package Imager_Project.imager;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class rgbFilterTest {

	@Test
	public void test() {
		String filePath = "C:/Users/shuri/git/Imager_v2/src/main/resources/testImages/ocean.jpg";
		System.out.println("filePath: "+filePath);
		BufferedImage testImg = null;
		try{
			testImg = ImageIO.read(new File(filePath));
		}
		catch (IOException e){
			System.out.println("An IO Exception was thrown");
		}
		
		imgFilter testFilter = new imgFilter(testImg);
		attrHash testHash = testFilter.rgbFilter();
	}

}











