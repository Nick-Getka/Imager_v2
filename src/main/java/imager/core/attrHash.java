package imager.core;

import java.util.HashMap;

public class attrHash {
	HashMap<String, Double> hmap = new HashMap<String, Double>();

	//Constructor
	public attrHash() {
		super();
	}
	
	//get and set for testing
	public HashMap<String, Double> getHmap() {
		return hmap;
	}

	public void setHmap(HashMap<String, Double> hmap) {
		this.hmap = hmap;
	}
	
	
	//Operations
	public void addAttr(attribute attr){
		hmap.put(attr.getName(), attr.getProb());
	}

	public void addAttr(String name, double prob){
		hmap.put(name, prob);
	}
	public double getAttr(String name){
		if (hmap.get(name) != null){
			return hmap.get(name);
		}
		else{
			return -1;//used for testing because -1 is illegal
				     //errors in the hash return -1 while errors in the 
					//the filters return 2
		}
	}
	public void mergeHash(attrHash sec){
		HashMap<String,Double> temp = new HashMap<String,Double>();
		temp.putAll(hmap);
		temp.putAll(sec.getHmap());
		
		hmap.clear();
		hmap.putAll(temp);
	}
	
	
}
