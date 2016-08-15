package imager.core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.BackPropagation;

import imager.filter.BlueFilter;
import imager.filter.LowResFilter;
import imager.pro.RGBPro;
import neuralnet.NeuralNet;

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

	public void main(String args[])
	{
		char userChoice = 'x';
		Scanner reader = new Scanner(System.in);

		do{
			System.out.println("Enter T for training");
			System.out.println("Enter E for testing");
			System.out.println("Q to exit");
			userChoice = reader.nextLine().charAt(0);
			userChoice = Character.toUpperCase(userChoice);
			
			switch(userChoice){
				case 'T': training();
					break;
				case 'E': testing();
					break;
			}
			
		}while ((userChoice)!='Q');
		
		reader.close();
	}
	
	public void training(){
		System.out.println("Training\n");
		
	}
	
	public  void testing(){
		System.out.println("Testing\n");
		File nNet = new File("src/main/resources/nnets/RGBNNet2.nnet");
		NeuralNetwork rgbNet = NeuralNetwork.createFromFile(nNet);
		
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
		RGBPro rgb = new RGBPro(low.filter());
		
		double data[] = { rgb.getBluePerc(), rgb.getGreenPerc(), rgb.getRedPerc() };
		
		rgbNet.setInput(data);
		rgbNet.calculate();
		
		System.out.println("Output: "+ rgbNet.getOutput().toString());
	}
}






























//
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.Scanner;
//
//import javax.imageio.ImageIO;
//
//import imager.filter.LowResFilter;
//import imager.pro.RGBPro;
//
////The pipeline will conduct the initial image processing 
////Images will be fed in a passed first to the Image Filters which will return the
////numbers on the image, those numbers will them be sent to the Neural Nets where the
////numbers will be weighted and relationships between the numbers estimated.
////Finally the relationships and weights will be sent to the conceptual spaces
////here the output of the Neural Networks will be matched with existing models created prior 
////to the image being processed. If the image doesn't match an existing model then either a new
////model will be added to the model library or an existing model will be modified to incorportate
////the new data from the image.
//public class pipeline {
//	//In main the image will be put into an ImageBuffer object
//	//This will be done by passing the path to the image to the program
//	//For now a test folder is hard coded with several options given to 
//	//The console
//	//test images will be stored in /src/main/resources/testImages/*
//	
//	public static void main(String args[])
//	{
//		String filePath = null;
//		Scanner reader = new Scanner(System.in);
//		BufferedImage img = null;
//		BufferedImage lowRes = null;
//		attrHash RGB = new attrHash();
//		try{
//			
//			System.out.println("Please enter what is in the image: ");
//			filePath = reader.nextLine();
//			filePath = "src/main/resources/testImages/plain.jpg";
//			System.out.println("filePath: "+filePath);
//			
//			img = ImageIO.read(new File(filePath));
//			lowRes = new LowResFilter(img).filter();
//			
//			RGB = new RGBPro(lowRes).pro();
//		}
//		catch (IOException e){
//			System.out.println("An IO Exception was thrown");
//		}
		
		
		
		
		
		
		
		
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
//			
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
		
//		reader.close();
//	}
//}
