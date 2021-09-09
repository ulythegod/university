package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import model.Eat;

import controller.Controller;
import forTheStorageManager.TheStorageManager;


public class TheServerThread implements Runnable{
	static Socket s;
	
	TheServerThread(Socket sc){
		s = sc;
	}

	public void run(){
			sendAnimalsToClient();
			getAnimalFromClient(); 	
	}

	public static void getAnimalFromClient(){ 
	
		try {
			ObjectInputStream objectIS = new ObjectInputStream(s.getInputStream()); 
			TheStorageManager.getStorageManager().create((Eat) objectIS.readObject());
			try {
				TheStorageManager.getStorageManager().save();
				sendAnimalsToClient(); 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public static void sendAnimalsToClient(){

	try {
		System.out.println("Отправка данных клиенту с сервера ");
		ObjectOutputStream objectOS = new ObjectOutputStream(s.getOutputStream());
		
			objectOS.writeObject(TheStorageManager.getStorageManager().getEntities());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
