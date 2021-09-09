package model;

import java.io.Serializable;

public class Eat implements Serializable{
	private int id;
	private boolean isPut;
	private String name;
	private float weight;
	public static final float max = 20;
	
	public Eat(String name, float weight) {
		super();
		this.name = name;
		this.weight = weight;
		if(weight <= 0) 
			throw new IllegalArgumentException("нельзя ввести отрицательную массу"); 
		if(weight >= max) 
			throw new IllegalArgumentException("масса должна быть меньше 20");
	}
	public Eat() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public boolean isPut() {
		return isPut;
	}
	public void setPut(boolean isPut) {
		this.isPut = isPut;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
