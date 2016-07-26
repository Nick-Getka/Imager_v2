package Imager_Project.imager;

import java.util.ArrayList;

public class conSpace {
	private ArrayList<model> modList;
	
	//Constructors
	//Default
	public conSpace(){
		super();
		modList = new ArrayList<model>();
		modList.add(new model("not found"));
	}
	//pre-existing model list
	public conSpace(model[] startList){
		for(int x =0; x < startList.length; x++)
		{
			addModel(startList[x]);
		}
	}
	
	//Model List Functions
	//Add new model to the list
	public void addModel(model newMod){
	    modList.add(newMod);
	}
	//search for existing model
	public model findModel(String mod){
		boolean found = false;
		int loc = 999;
		for(int x = 0; x < modList.size(); x++)
		{
			if (!found)
			{
				if(mod == modList.get(x).getName())
				{
					loc = x;
					found = true;
				}
			}
		}
		if (found)
		{
			return modList.get(loc);
			}
		else
		{
			return modList.get(0);
		}
	}
	
	public model think(netOutput data){
		//Temporary Test code
		if(modList.size() < 2)
		{
			model example = new model("example");
			addModel(example);
			return example;
		}
		else
		{
			return modList.get(1);
		}
		
		
	}
}
