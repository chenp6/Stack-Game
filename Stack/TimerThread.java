package Stack;

import javax.swing.JTextField;

public class TimerThread extends Thread {
	JTextField text;
	private int sec = 0;

	TimerThread(JTextField text) {
		super();
		this.text = text;
	}

	public void run() {
		while (!App.pass && !App.failed) {
			try {
				sleep(1000);
				sec++;
				App.time = sec;
				text.setText(sec + " sec");
				text.repaint();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
}
