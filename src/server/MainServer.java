package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashSet;


public class MainServer implements Runnable {
	Thread theThread;
	MainServer theServerT;
	public static int DEFAULT_PORT = 5050;
	ServerSocket ss;
	HashSet<TheServerThread> theSetThread = new HashSet<TheServerThread>();
	int port;
	boolean isStarted = false;
	
	MainServer(int port){
		try {
			ss = new ServerSocket(port);
			isStarted = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public MainServer(){
		this(DEFAULT_PORT);
	}
	
	
	public void run() {
		
		try {
			
			while(isStarted){
				System.out.println("Сервер запущен и ждет клиентов");
				Socket s = ss.accept();					
				System.out.println("Клиент " + s.getInetAddress() + "  подключен");
				TheServerThread client = new TheServerThread(s);
				theSetThread.add(client);
				Thread tr = new Thread(client);
				tr.start();						
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
}
	
	public void StartServer(int port){
		
		this.port = port;
		theThread = new Thread(this);
		this.setServerThread(theThread);
		theThread.start();
	}
	
	public void StopServer(){
		if(isStarted){

		}
	}

	public static int getDEFAULT_PORT() {
		return DEFAULT_PORT;
	}
	public static void setDEFAULT_PORT(int dEFAULT_PORT) {
		DEFAULT_PORT = dEFAULT_PORT;
	}
	public ServerSocket getSs() {
		return ss;
	}
	public void setSs(ServerSocket ss) {
		this.ss = ss;
	}
	public HashSet<TheServerThread> getTheSetThread() {
		return theSetThread;
	}
	public void setTheSetThread(HashSet<TheServerThread> theSetThread) {
		this.theSetThread = theSetThread;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	public boolean getIsStarted(){
		return isStarted;
	}
	
	public void setIsStarted(boolean isStarted){
		this.isStarted = isStarted;
	}
	
	public Thread getServerThread() {
		return theThread;
	}
	
	public void setServerThread(Thread serverThread) {
		this.theThread = serverThread;
	}
}

