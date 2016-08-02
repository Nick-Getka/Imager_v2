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
	public imgFilter()
	{
		super();
		this.imgToPro = null;
	}
	public imgFilter(BufferedImage img)
	{
		super();
		this.imgToPro = img;
	}

	//Getter and Setter
	public BufferedImage getImgToPro() {return imgToPro;}
	public void setImgToPro(BufferedImage imgToPro) {this.imgToPro = imgToPro;}
	
	public attrHash rgbFilter(double perc){//The number is the percentage of the picture covered
		attribute red = new attribute();
		attribute green = new attribute();
		attribute blue = new attribute();
		
		red.setName("red");
		green.setName("green");
		blue.setName("blue");
		
		double w = imgToPro.getWidth();
	    double h = imgToPro.getHeight();
	    
	    double rCount = 0;
	    double bCount = 0;
	    double gCount = 0;
	    
	    for(int y =0; y < h; y++)
	    {
	    	for(int x = 0; x < w; x += (1/perc))
	    	{
	    		int clr = imgToPro.getRGB(x,y); 
	    		int rVal = (clr & 0x00ff0000) >> 16;
	    		int gVal = (clr & 0x0000ff00) >> 8;
	    	    int bVal =  clr & 0x000000ff;
	    	    
	    	    if(rVal > bVal && rVal > gVal){
	    	    	
	    	    	rCount += 1;
	    	    }
	    	    else if(bVal >= gVal && bVal > rVal){
	    	    	bCount += 1;
	    	    }
	    	    else if(gVal > bVal && gVal > rVal){
	    	    	gCount += 1;
	    	    } 
	    	    else
	    	    {
	    	    	
	    	    }
	    	}
	    }
		
	    double total = (h*w);
	    if (perc <= .5){
	    	total *= perc;
	    }
		
		double rProb = rCount/total;
		double gProb = gCount/total;
		double bProb = bCount/total;
		
		red.setProb(rProb);
		blue.setProb(bProb);
		green.setProb(gProb);
		
		System.out.println("total: " + total);
		System.out.println("Percent: "+ perc);
		System.out.println("advacer: "+ (1+ (1/perc)));
		System.out.println("Red Prob: "+ rProb);
		System.out.println("Green Prob: "+ gProb);
		System.out.println("Blue Prob: "+ bProb);
		

		
	    attrHash tmp = new attrHash();
	    tmp.addAttr(red);
	    tmp.addAttr(green);
	    tmp.addAttr(blue);
		return tmp;
	}
}
