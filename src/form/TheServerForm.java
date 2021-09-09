package form;

import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;

public class TheServerForm extends Frame{
	
	TextField portTF = new TextField("");
	Button connectButton = new Button("Старт");
	Button disconnectButton = new Button("Стоп");
	
	public TheServerForm(){
		
		setSize(350, 150);
		
		portTF.setBounds(15, 40, 130, 20);
		add(portTF);
		connectButton.setBounds(15, 65, 130, 30);
		add(connectButton);
		disconnectButton.setBounds(165, 65, 130, 30);
		disconnectButton.setEnabled(false);
		add(disconnectButton);
		
		this.setLayout(null);
	}

	public TextField getPortTF() {
		return portTF;
	}

	public void setPortTF(TextField portTF) {
		this.portTF = portTF;
	}

	public Button getConnectButton() {
		return connectButton;
	}

	public void setConnectButton(Button connectButton) {
		this.connectButton = connectButton;
	}

	public Button getDisconnectButton() {
		return disconnectButton;
	}

	public void setDisconnectButton(Button disconnectButton) {
		this.disconnectButton = disconnectButton;
	}

}

