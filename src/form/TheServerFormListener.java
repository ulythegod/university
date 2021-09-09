package form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import controller.Controller;

import server.MainServer;

public class TheServerFormListener implements ActionListener{
	
	TheServerForm thisForm;
	Integer in;
	
	public TheServerFormListener(TheServerForm thisForm){

		this.thisForm = thisForm;
		this.thisForm.getDisconnectButton().addActionListener(this);
		this.thisForm.getConnectButton().addActionListener(this);
		
		this.thisForm.addWindowListener(new WindowListener(){
			public void windowOpened(WindowEvent e) { 
			} 

			public void windowClosing(WindowEvent e) { 
			System.exit(0); 
			} 

			public void windowClosed(WindowEvent e) { 
			} 

			public void windowIconified(WindowEvent e) { 
			} 

			public void windowDeiconified(WindowEvent e) { 
			} 

			public void windowActivated(WindowEvent e) { 
			} 

			public void windowDeactivated(WindowEvent e) { 

			} 
			});
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(thisForm.getConnectButton())){
			in = new Integer(thisForm.getPortTF().getText());
			Controller.forStartServer(in);
			
			thisForm.getConnectButton().setEnabled(false);
			thisForm.getDisconnectButton().setEnabled(true);
			thisForm.getPortTF().setEnabled(false);
		}
		if(event.getSource().equals(thisForm.getDisconnectButton())){
			
			thisForm.getConnectButton().setEnabled(true);
			thisForm.getDisconnectButton().setEnabled(false);
			thisForm.getPortTF().setEnabled(true);
		}
	}

}
