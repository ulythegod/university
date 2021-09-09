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
			throw new IllegalStateException("������� �� ����");
		if(!(food instanceof Animal))
			throw new IllegalArgumentException("������� ���� ������ ��������");
		if(!((Animal) food).isAlive())
			throw new IllegalStateException("������� �� ���� ��� ������ ��������"); 
		((Animal) food).setAlive(false); 
		super.setWeight(this.getWeight()+food.getWeight());
		
	}
}
	
	


