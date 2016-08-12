package Imager_Project.imager;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import org.junit.Test;

import imager.pro.RGBPro;

public class RGBProTest {

	@Test
	public void redTest() {

		String filePath = "src/main/resources/testImages/red.jpg";
		System.out.println("filePath: "+filePath);
		BufferedImage testImg = null;
		try{
			testImg = ImageIO.read(new File(filePath));
		}
		catch (IOException e){
			System.out.println("An IO Exception was thrown");
		}

		RGBPro testFilter = new RGBPro(testImg);
		HashMap<String, Double> testHash = testFilter.pro();

		double bAtt = testHash.get("blue");
		double gAtt = testHash.get("green");
		double rAtt = testHash.get("red");

		assertEquals(0, gAtt, 0);
		assertEquals(0, bAtt, 0);
		assertTrue(rAtt == 1.0);

	}

	@Test
	public void blueTest() {
		String filePath = "src/main/resources/testImages/blue.jpg";
		System.out.println("filePath: "+filePath);
		BufferedImage testImg = null;
		try{
			testImg = ImageIO.read(new File(filePath));
		}
		catch (IOException e){
			System.out.println("An IO Exception was thrown");
		}
		
		RGBPro testFilter = new RGBPro(testImg);
		HashMap<String, Double> testHash = testFilter.pro();

		double bAtt = testHash.get("blue");
		double gAtt = testHash.get("green");
		double rAtt = testHash.get("red");
		
		assertEquals(0, gAtt, 0);
		assertEquals(0, rAtt, 0);
		assertTrue(bAtt == 1.0);		
	}
	
	@Test
	public void grenTest() {
		String filePath = "src/main/resources/testImages/green.jpg";
		System.out.println("filePath: "+filePath);
		BufferedImage testImg = null;
		try{
			testImg = ImageIO.read(new File(filePath));
		}
		catch (IOException e){
			System.out.println("An IO Exception was thrown");
		}
		
		RGBPro testFilter = new RGBPro(testImg);
		HashMap<String, Double> testHash = testFilter.pro();

		double bAtt = testHash.get("blue");
		double gAtt = testHash.get("green");
		double rAtt = testHash.get("red");
		
		assertEquals(0, rAtt, 0);
		assertEquals(0, bAtt, 0);
		assertTrue(gAtt == 1.0);		
	}
	
	@Test
	public void beachTest() {
		
		String filePath = "src/main/resources/testImages/beach.jpg";
		System.out.println("filePath: "+filePath);
		BufferedImage testImg = null;
		try{
			testImg = ImageIO.read(new File(filePath));
		}
		catch (IOException e){
			System.out.println("An IO Exception was thrown");
		}
		
		RGBPro testFilter = new RGBPro(testImg);
		HashMap<String, Double> testHash = testFilter.pro();

		double bAtt = testHash.get("blue");
		double gAtt = testHash.get("green");
		double rAtt = testHash.get("red");
		
		assertEquals(.2, rAtt, .09);
		assertEquals(.2, gAtt, .09);
		assertEquals(.5, bAtt, .09);	
		
	}
}











