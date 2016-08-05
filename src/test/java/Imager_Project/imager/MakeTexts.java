package Imager_Project.imager;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.imageio.ImageIO;

import org.junit.Test;

import imager.core.attrHash;
import imager.pro.RGBPro;

public class MakeTexts {

	@Test
	public void test() {
		try {
			Writer outFile = new FileWriter("src/main/resources/testImages/plain/plainData.txt");
			for(int x = 1; x < 21; x++ ){
				String filePath = "src/main/resources/testImages/plain/"+x+".jpg";
				System.out.println("filePath: "+filePath);
				BufferedImage testImg = null;
				try{
					testImg = ImageIO.read(new File(filePath));
				}
				catch (IOException e){
					System.out.println("An IO Exception was thrown");
				}

				RGBPro testFilter = new RGBPro(testImg);
				attrHash testHash = testFilter.pro(1);

				Double bAtt = testHash.getAttr("blue");
				Double gAtt = testHash.getAttr("green");
				Double rAtt = testHash.getAttr("red");

				outFile.write(bAtt.toString()+"\t"+gAtt.toString()+"\t"+rAtt.toString());
				outFile.write(System.getProperty( "line.separator" ));
			}
			outFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}

