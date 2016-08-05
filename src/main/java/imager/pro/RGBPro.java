package imager.pro;

import java.awt.image.BufferedImage;

import imager.core.attrHash;
import imager.core.attribute;



//The imgFilter will process any image sent to the program
//The filters will be need to return labeled Attributes with 0-1 values
//The filter network will need to be dynamic and it will need to be easy
//to add new filters.  Filters may even need to call other filters
//for the most part Filters will call extant image processing software
public class RGBPro extends ImgPro {
	
	//Constructors
	public RGBPro()
	{
		super();
	}
	public RGBPro(BufferedImage img)
	{
		super(img);
	}
	
	public attrHash pro(double perc){//The number is the percentage of the picture covered
		attribute red = new attribute();
		attribute green = new attribute();
		attribute blue = new attribute();
		
		red.setName("red");
		green.setName("green");
		blue.setName("blue");
		
		double w = getImg().getWidth();
	    double h = getImg().getHeight();
	    
	    double rCount = 0;
	    double bCount = 0;
	    double gCount = 0;
	    
	    for(int y =0; y < h; y++)
	    {
	    	for(int x = 0; x < w; x += (1/perc))
	    	{
	    		int clr = getImg().getRGB(x,y); 
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
		
	    attrHash tmp = new attrHash();
	    tmp.addAttr(red);
	    tmp.addAttr(green);
	    tmp.addAttr(blue);
		return tmp;
	}
}
