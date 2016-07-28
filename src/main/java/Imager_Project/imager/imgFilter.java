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
	
	public attrHash rgbFilter(){//Color must be red, green, or blue
		attribute red = new attribute();
		attribute green = new attribute();
		attribute blue = new attribute();
		
		red.setName("red");
		green.setName("green");
		blue.setName("blue");
		
		int w = imgToPro.getWidth();
	    int h = imgToPro.getHeight();
	    int rCount = 0;
	    int bCount = 0;
	    int gCount = 0;
	    
	    for(int y =0; y < h; y++)
	    {
	    	for(int x =0; x < w; x++)
	    	{
	    		int clr = imgToPro.getRGB(x,y); 
	    		int rVal = (clr & 0x00ff0000) >> 16;
	    		int gVal = (clr & 0x0000ff00) >> 8;
	    	    int bVal =  clr & 0x000000ff;
	    	    
	    	    System.out.println("clr: " + clr);
	    	    System.out.println("rVal: " + rVal);
	    	    System.out.println("gVal: " + gVal);
	    	    System.out.println("bVal: " + bVal);
	    	    
	    	    if(rVal > gVal && rVal > bVal){
	    	    	System.out.println("rCount added");
	    	    	rCount++;
	    	    }
	    	    else if(bVal > gVal && bVal > rVal){
	    	    	System.out.println("bCount added");
	    	    	bCount++;
	    	    }
	    	    else if(gVal > bVal && gVal >rVal){
	    	    	System.out.println("gCount added");
	    	    	gCount++;
	    	    }
	    	}
	    }
		
		int total = h*w;
		red.setProb(rCount/total);
		blue.setProb(bCount/total);
		green.setProb(gCount/total);
		
		System.out.println("Red Prob: "+ red.getProb());
		System.out.println("Green Prob: "+ green.getProb());
		System.out.println("Blue Prob: "+ blue.getProb());
		
	    attrHash tmp = new attrHash();
	    tmp.addAttr(red);
	    tmp.addAttr(green);
	    tmp.addAttr(blue);
		return tmp;
	}
}
