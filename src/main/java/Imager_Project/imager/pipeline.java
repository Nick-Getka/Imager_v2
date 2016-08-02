package Imager_Project.imager;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

//The pipeline will conduct the initial image processing 
//Images will be fed in a passed first to the Image Filters which will return the
//numbers on the image, those numbers will them be sent to the Neural Nets where the
//numbers will be weighted and relationships between the numbers estimated.
//Finally the relationships and weights will be sent to the conceptual spaces
//here the output of the Neural Networks will be matched with existing models created prior 
//to the image being processed. If the image doesn't match an existing model then either a new
//model will be added to the model library or an existing model will be modified to incorportate
//the new data from the image.
public class pipeline {
	//In main the image will be put into an ImageBuffer object
	//This will be done by passing the path to the image to the program
	//For now a test folder is hard coded with several options given to 
	//The console
	//test images will be stored in /src/main/resources/testImages/*
	
	public static void main(String args[])
	{
		String filePath = null;
		Scanner reader = new Scanner(System.in);
		neuralNet net = new neuralNet();
		conSpace space = new conSpace();
		
		
		System.out.println("Opening Image Pipeline");
		System.out.println("Please enter the file path to an image:");
		filePath = reader.nextLine();
		System.out.println("file: "+ filePath);	
		
		filePath = "/home/admin/workspace/imagepro//src/main/resources/testImages/plain.jpg";
		System.out.println("filePath: "+filePath);
		BufferedImage imgToProcess = null;
		try{
			imgToProcess = ImageIO.read(new File(filePath));
		}
		catch (IOException e){
			System.out.println("An IO Exception was thrown");
		}
		
		attrHash globalHash = new attrHash();
		imgFilter pro = new imgFilter(imgToProcess);
		globalHash.mergeHash(pro.rgbFilter(1));
		
//		imgFilter pro = new imgFilter(imgToProcess);
//		attribute subList = pro.filter();
//		netOutput out = net.test(subList);
//		model determined = space.think(out);
//		
//		
//		System.out.println("Is the the Image for training (1) or processing (2)");
//		String userChoice = reader.nextLine();
//		System.out.println(userChoice);
//		if (userChoice.contentEquals("1"))
//		{
//			System.out.println("Please enter what is in the image: ");
//			String imgContent = reader.nextLine();
//			
//			model subject;
//			subject = space.findModel(imgContent);
//			
//			if("not found".equals(subject.getName()))
//			{
//				space.addModel(new model(imgContent));	
//				net.firstProp(determined );
//				System.out.println(determined.getName());
//			}
//			else 
//			{
//				net.backProp(determined, subject);
//			}
//			
//		}
//		else if (userChoice.contentEquals("2"))
//		{
//			System.out.println("The program determined the image to be: "+determined.getName());
//		} else {
//			System.out.println("Nothing");
//		}
		
		reader.close();
	}
}
