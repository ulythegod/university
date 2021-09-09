package forTheStorageManager;

import java.io.*;
import java.util.HashSet;
import model.Animal;
import model.Eat;
import model.Herbivorous;
import model.Predator;

public class TheStorageManager implements Serializable {
	private static int COUNTER = 0;
	private HashSet<Eat> entities = new HashSet<Eat>();
	final private String FileName = "fileanimals.dat";
	private static TheStorageManager storageManager = null;
	
	public static TheStorageManager getStorageManager(){
		if (storageManager == null)
			storageManager = new TheStorageManager();
		return storageManager;
	}
	
	private TheStorageManager(){}
	
	public void save() throws Exception{

			FileOutputStream fOS = new FileOutputStream(FileName);
			ObjectOutputStream objectOS = new ObjectOutputStream(fOS);
			
			objectOS.writeObject(storageManager);
			fOS.close();

	}
	
	public void load() throws Exception{

			FileInputStream fIS = new FileInputStream(FileName);
			ObjectInputStream objectIS = new ObjectInputStream(fIS);
			
			storageManager = (TheStorageManager) objectIS.readObject();	
			fIS.close(); 
	}
	
    public Eat create (Eat eat){
    	eat.setId(COUNTER++);
    	entities.add(eat);
    	return eat;
    }
	
    public void update (Eat eat){
    	if (!entities.contains(eat))
    		throw new IllegalArgumentException("Сущность не в хранилище");
    	entities.remove(eat);
    	entities.add(eat);
    }	
    
	public void delete (Eat eat){
    	if (!entities.contains(eat))
    		throw new IllegalArgumentException("Сущность не в хранилище");
    	entities.remove(eat);
	}
	
	public void deleteAll(){
		entities.clear();
	}
	
	public HashSet<Eat> getAliveAnumals(){
		HashSet<Eat> aliveEntities = new HashSet<Eat>();
		for(Eat eat: entities){
			if(eat instanceof Animal)
				if(((Animal) eat).isAlive()){
					aliveEntities.add(eat);
				}
		}
		
		return aliveEntities;
	}
	
	public HashSet<Eat> getPredator(){
		HashSet<Eat> predatorEntities = new HashSet<Eat>();
		for(Eat eat: entities){
			if(eat instanceof Animal)
				if((Animal) eat instanceof Predator){
					predatorEntities.add(eat);
				}
		}
		
		return predatorEntities;
	}
	
	public HashSet<Eat> getHerbivorous(){
		HashSet<Eat> herbivorousEntities = new HashSet<Eat>();
		for(Eat eat: entities){
			if(eat instanceof Animal)
				if((Animal) eat instanceof Herbivorous){
					herbivorousEntities.add(eat);
				}
		}
		
		return herbivorousEntities;
	}
	
	public Eat getAnimailById(int theId){
		for(Eat eat: entities)
			if(eat.getId() == theId){
				return eat;
			}
		return null;
	}
	
	public HashSet<Eat> getEntities() {
		return entities;
	}

	public void setEntities(HashSet<Eat> entities) {
		this.entities = entities;
	}

	public String getFileName() {
		return FileName;
	}

}

