package controller;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;

import forTheStorageManager.TheStorageManager;

import model.Animal;
import model.Eat;
import model.Grass;
import model.Herbivorous;
import model.Predator;

import server.MainServer;
import server.TheServerThread;

public class Controller {
	
	public static MainServer newSer;
    public static TheStorageManager stManager;
	
	public static void forStartServer(int port){
		
		newSer = new MainServer();
		newSer.StartServer(port);
	}
	
	public static void takeAnimal(int d){

		if(d == 0)
			createNewAnimal();
	}
	
	public static void createNewAnimal(){
		TheServerThread.getAnimalFromClient(); 
	}
	
	
}
