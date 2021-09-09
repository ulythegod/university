package model;

public class Herbivorous extends Animal{

	public Herbivorous(String name, float weight, boolean isAlive) {
		super(name, weight, isAlive);
	}

	public Herbivorous(String name, float weight) {
		super(name, weight);
	}

	public void eat(Eat food) {
		if(!(food instanceof Grass))
			throw new IllegalArgumentException("Травоядные едят только траву");
		super.setWeight(this.getWeight()+food.getWeight());
	}

}
