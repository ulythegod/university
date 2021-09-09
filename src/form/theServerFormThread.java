package form;

public class theServerFormThread implements Runnable{

	public void run() {
		TheServerForm theSForm = new TheServerForm();
		TheServerFormListener theAnimalsFormL = new TheServerFormListener(theSForm);
		theSForm.setVisible(true);
		
	}

}
