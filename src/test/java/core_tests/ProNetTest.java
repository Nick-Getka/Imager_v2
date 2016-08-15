package core_tests;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import org.junit.Test;

import imager.core.FilterNet;
import imager.core.ProNet;

public class ProNetTest {

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
		
		FilterNet testFNet = new FilterNet(testImg);
		ProNet testPNet = new ProNet(testFNet.filter());
		HashMap<String, Double> testHash = testPNet.pro();

		double bAtt = testHash.get("blue");
		double gAtt = testHash.get("green");
		double rAtt = testHash.get("red");
		
		assertEquals(.2, rAtt, .09);
		assertEquals(.2, gAtt, .09);
		assertEquals(.5, bAtt, .09);	
	}
}
