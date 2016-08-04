package imager.core;

public class attribute {
	//Variables
	private String name;//The name of the attribute
	private double prob;//The normalized (between 0 and 1) number associated with the attribute
	
	
	
	//Constructors
	public attribute() {
		super();
		name = "";
		prob = 2;
	}
	public attribute(String name, double prob) {
		super();
		this.name = name;
		this.prob = prob;
	}
	
	
	
	//Getter and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getProb() {
		return prob;
	}
	public void setProb(double prob) {
		this.prob = prob;
	}

	
	
	//Testers
	public boolean isNamed(){
		return !(name.isEmpty());
	}
	public boolean isLegal(){
		return (prob < 1) ? true : false;
	}
	public boolean fullTest(){
		return (isNamed() && isLegal());
	}
}
