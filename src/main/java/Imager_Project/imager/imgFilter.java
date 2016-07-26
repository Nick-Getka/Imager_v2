package Imager_Project.imager;

import java.awt.image.BufferedImage;

//The imgFilter will process any image sent to the program
//The filters will be need to return labeled Attributes with 0-1 values
//The filter network will need to be dynamic and it will need to be easy
//to add new filters.  Filters may even need to call other filters
//for the most part Filters will call extant image processing software
public class imgFilter {
	//Variables
	private BufferedImage imgToPro;
	
	//Constructors
	public imgFilter(BufferedImage img)
	{
		super();
		this.imgToPro = img;
	}

	//Getter and Setter
	public BufferedImage getImgToPro() {return imgToPro;}
	public void setImgToPro(BufferedImage imgToPro) {this.imgToPro = imgToPro;}
	
	public AttrProbList filter(){
		//Temporary values
		AttrProbList temp = new AttrProbList();
		temp.add("blue", .1);
		temp.add("large", .2);
		temp.add("high", .3);
		temp.add("low", .7);
		temp.add("green", .5);
		
		return temp;
	}
}
