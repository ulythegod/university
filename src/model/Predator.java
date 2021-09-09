package model;

public class Predator extends Animal{

	public Predator(String name, float weight) {
		super(name, weight);
		
	}

	public Predator(String name, float weight, boolean isAlive) {
		super(name, weight, isAlive);
		
	}

	public void eat(Eat food) {
		if(!isAlive)
			throw new IllegalStateException("мертвые не едят");
		if(!(food instanceof Animal))
			throw new IllegalArgumentException("хищники едят только животных");
		if(!((Animal) food).isAlive())
			throw new IllegalStateException("жищники не едят уже убитых животных"); 
		((Animal) food).setAlive(false); 
		super.setWeight(this.getWeight()+food.getWeight());
		
	}
}
	
	


