package model;

public abstract class Animal extends Eat{
	protected boolean isAlive;

	public Animal(String name, float weight, boolean isAlive) {
		super(name, weight);
		this.isAlive = isAlive;
	}

	public Animal(String name, float weight) {
		super(name, weight);
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public Animal() {
		super();
	}
	abstract public void eat(Eat food);
	public boolean kill(){
		if(!isAlive)
			throw new IllegalStateException("животное уже убито");
		this.isAlive = false;
		return true;		
	}
	
	public String getInfo(){
		if(isAlive)
			return (this.getId()+" "+this.getName()+" "+this.getWeight()+" животное живое");
		else
			return (this.getId()+" "+this.getName()+" "+this.getWeight()+" животное мертвое");
	}
	

}
