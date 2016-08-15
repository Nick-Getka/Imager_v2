package filter_tests;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

import imager.filter.LowResFilter;

public class LowResFilterTest {

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
		
		LowResFilter low = new LowResFilter(testImg);
		
		BufferedImage LowResTestImg = low.filter();
		
		int originalSize = testImg.getHeight()*testImg.getWidth();
		int newSize = LowResTestImg.getHeight()*LowResTestImg.getWidth();
		
		assertTrue((originalSize/(100)) == newSize);
	}

	@Test
	public void scaleTest() {
		String filePath = "src/main/resources/testImages/plain.jpg";
		System.out.println("filePath: "+filePath);
		BufferedImage testImg = null;
		try{
			testImg = ImageIO.read(new File(filePath));
		}
		catch (IOException e){
			System.out.println("An IO Exception was thrown");
		}
		
		int scale = 25;
		LowResFilter low = new LowResFilter(testImg);
		BufferedImage LowResTestImg = low.filter(scale);
		
		int originalSize = testImg.getHeight()*testImg.getWidth();
		int newSize = LowResTestImg.getHeight()*LowResTestImg.getWidth();
		
		assertTrue((originalSize/(scale*scale)) == newSize);
	}
}
