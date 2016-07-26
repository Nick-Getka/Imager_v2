package Imager_Project.imager;

import java.util.ArrayList;

//The Attribute-Probability list will contain the names and 1-0 values of the 
//the image's characteristics to pass to the neural network
public class AttrProbList {
	private ArrayList<String> attr;
	private ArrayList<Double> prob;
	
	//Constructors
	public AttrProbList(){
		attr = new ArrayList<String>();
		prob = new ArrayList<Double>();
	}

	//Getters and Setters
	public ArrayList<String> getAttr() {return attr;}
	public void setAttr(ArrayList<String> attr) {this.attr = attr;}
	public ArrayList<Double> getProb() {return prob;}
	public void setProb(ArrayList<Double> prob) {this.prob = prob;}
	
	public void add(String a, double p){
		attr.add(a);
		prob.add(p);
	}
}
