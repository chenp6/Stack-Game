package Stack;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Utils {

	static public void clearPanels() {
		int len = App.frame.getContentPane().getComponentCount();
		for (int i = 0; i < len; i++)
			App.frame.getContentPane().remove(0);
	}

	static public void clearPanel(JPanel panel) {
		int len = panel.getComponentCount();
		for (int i = 0; i < len; i++)
			panel.remove(0);
	}

	static public void repaintPanels() {
		App.frame.getContentPane().revalidate();
		App.frame.getContentPane().repaint();
	}

	static public void repaintComponent(JComponent component) {
		component.revalidate();
		component.repaint();
	}

	static public ImageIcon getIcon(String url) {
		return new ImageIcon(new Utils().getClass().getClassLoader().getResource(url));
	}

	static public ImageIcon getIcon(String url, int width, int height) {
		ImageIcon icon = Utils.getIcon(url);
		Image scaleImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		icon.setImage(scaleImage);
		return icon;
	}

	static public JTextField makeTimer() {
		JTextField timerText = new JTextField();
		timerText.setText(0 + " sec");
		timerText.setHorizontalAlignment(SwingConstants.CENTER);
		timerText.setEditable(false);
		timerText.setColumns(10);
		return timerText;
	}

	static public int getRandomInt() {
		int num = (int) (Math.random() * Integer.MAX_VALUE);
		return num; // 隨機整數
	}

	static public int getRandomInt(int end) {
		int num = (int) (Math.random() * end);
		return num; // 括號內為上限(不包含)
	}

	static public int getRandomInt(int start, int end) {
		int num = (int) (Math.random() * (end - start));
		return start + num; // 括號內為上限(不包含)
	}

	static public Object getRandomArrayItem(Object[] array) {
		int index = getRandomInt(array.length);
		return array[index];
	}
}
