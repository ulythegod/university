package debug;

import model.Herbivorous;
import model.Predator;
import forTheStorageManager.TheStorageManager;
import form.TheServerForm;
import form.TheServerFormListener;
import form.theServerFormThread;


public class Main {

	public static void init () throws Exception{
		TheStorageManager.getStorageManager().load();
	}
	public static void test() throws Exception{
		TheStorageManager.getStorageManager().deleteAll();
		TheStorageManager.getStorageManager().save();
		TheStorageManager.getStorageManager().load();
		
		Herbivorous pigeon = new Herbivorous("Голубь", 2, true);
		Herbivorous rat = new Herbivorous("Мышь", 10, true);	
		Predator fox = new Predator("Лиса", 5, true); 
		Predator wolf = new Predator("Волк", 5, false);
		
		TheStorageManager.getStorageManager().create(pigeon);
		TheStorageManager.getStorageManager().create(rat);
		
		TheStorageManager.getStorageManager().save();		
		TheStorageManager.getStorageManager().load();
				
		TheStorageManager.getStorageManager().create(fox);
		TheStorageManager.getStorageManager().create(wolf);
		
		TheStorageManager.getStorageManager().save();
		TheStorageManager.getStorageManager().load();
		
		//TheStorageManager.getStorageManager().getAliveAnumals();
		//TheStorageManager.getStorageManager().getAnimailById(2);
		//TheStorageManager.getStorageManager().getHerbivorous();
		//TheStorageManager.getStorageManager().getPredator();
		//TheStorageManager.getStorageManager().getEntities();
	}
	public static void starter(){
		theServerFormThread theSFormT = new theServerFormThread(); 
		Thread t = new Thread(theSFormT); 
		t.start();		
	}
	public static void main(String[] args) {
		try {	
			init();
			starter();
		    //test();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
