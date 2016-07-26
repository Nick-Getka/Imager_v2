package Imager_Project.imager;

import java.util.ArrayList;

//Models are a list of Attributes associated 
public class model {
	//The model contains a 2D array of Image Attributes
	
	//Member Variables
	private String name;
	private ArrayList<String> imgAttr;
	
	//Constructors
	//Default
	public model(){
		super();
		this.name = "Unnamed";
		imgAttr = new ArrayList<String>();
		
	}
	//Name no Attributes
	public model(String n){
		super();
		this.name = n;
		imgAttr = new ArrayList<String>();
		imgAttr.add(n);
	}
	//Name and Attributes
	public model(String n, String[] intAttr) {
		super();
		this.name = n;
		for(int x =0; x < intAttr.length; x++)
		{
			imgAttr.add(intAttr[x]);
		}
	}

	//Getters and Setters
	//Name
	public String getName(){return this.name;}
	public void setName(String n){this.name = n;}
	//Attributes
	public ArrayList<String> getAttr(){ return this.imgAttr;	}
	public void addAttr(String newAttr)
	{
		imgAttr.add(newAttr);
	}
}
