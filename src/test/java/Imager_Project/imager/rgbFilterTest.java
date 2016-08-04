package Imager_Project.imager;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

import imager.core.attrHash;
import imager.pro.imgFilter;

public class rgbFilterTest {

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
		
		imgFilter testFilter = new imgFilter(testImg);
		attrHash testHash = testFilter.rgbFilter(1);
		
		double bAtt = testHash.getAttr("blue");
		double gAtt = testHash.getAttr("green");
		double rAtt = testHash.getAttr("red");
		
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
		
		imgFilter testFilter = new imgFilter(testImg);
		attrHash testHash = testFilter.rgbFilter(1);
		
		double bAtt = testHash.getAttr("blue");
		double gAtt = testHash.getAttr("green");
		double rAtt = testHash.getAttr("red");
		
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
		
		imgFilter testFilter = new imgFilter(testImg);
		attrHash testHash = testFilter.rgbFilter(1);
		
		double bAtt = testHash.getAttr("blue");
		double gAtt = testHash.getAttr("green");
		double rAtt = testHash.getAttr("red");
		
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
		
		imgFilter testFilter = new imgFilter(testImg);
		attrHash testHash = testFilter.rgbFilter(1);
		
		double bAtt = testHash.getAttr("blue");
		double gAtt = testHash.getAttr("green");
		double rAtt = testHash.getAttr("red");
		
		assertEquals(.2, rAtt, .09);
		assertEquals(.2, gAtt, .09);
		assertEquals(.5, bAtt, .09);	
	}
	
	@Test
	public void percHalfTest() {
		String filePath = "C:/Users/shuri/git/Imager_v2/src/main/resources/testImages/beach.jpg";
		System.out.println("filePath: "+filePath);
		BufferedImage testImg = null;
		try{
			testImg = ImageIO.read(new File(filePath));
		}
		catch (IOException e){
			System.out.println("An IO Exception was thrown");
		}
		
		imgFilter testFilter = new imgFilter(testImg);
		attrHash testHash = testFilter.rgbFilter(.5);
		
		double bAtt = testHash.getAttr("blue");
		double gAtt = testHash.getAttr("green");
		double rAtt = testHash.getAttr("red");
		
		assertEquals(.2, rAtt, .09);
		assertEquals(.2, gAtt, .09);
		assertEquals(.5, bAtt, .09);	
	}
	@Test
	public void percQuarterTest() {
		String filePath = "C:/Users/shuri/git/Imager_v2/src/main/resources/testImages/beach.jpg";
		System.out.println("filePath: "+filePath);
		BufferedImage testImg = null;
		try{
			testImg = ImageIO.read(new File(filePath));
		}
		catch (IOException e){
			System.out.println("An IO Exception was thrown");
		}
		
		imgFilter testFilter = new imgFilter(testImg);
		attrHash testHash = testFilter.rgbFilter(.25);
		
		double bAtt = testHash.getAttr("blue");
		double gAtt = testHash.getAttr("green");
		double rAtt = testHash.getAttr("red");
		
		assertEquals(.2, rAtt, .09);
		assertEquals(.2, gAtt, .09);
		assertEquals(.5, bAtt, .09);	
	}
	
	@Test
	public void percThreeQuartersTest() {
		String filePath = "C:/Users/shuri/git/Imager_v2/src/main/resources/testImages/beach.jpg";
		System.out.println("filePath: "+filePath);
		BufferedImage testImg = null;
		try{
			testImg = ImageIO.read(new File(filePath));
		}
		catch (IOException e){
			System.out.println("An IO Exception was thrown");
		}
		
		imgFilter testFilter = new imgFilter(testImg);
		attrHash testHash = testFilter.rgbFilter(.75);
		
		double bAtt = testHash.getAttr("blue");
		double gAtt = testHash.getAttr("green");
		double rAtt = testHash.getAttr("red");
		
		assertEquals(.2, rAtt, .09);
		assertEquals(.2, gAtt, .09);
		assertEquals(.5, bAtt, .09);	
	}
}











