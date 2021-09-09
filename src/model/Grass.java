package model;

public class Grass extends Eat{

	public Grass() {
		super();
	}

	public Grass(String name, float weight) {
		super(name, weight);
	}
	
	public String getInfo(){
		return (this.getId()+" "+this.getName()+" "+this.getWeight());
	}
}

