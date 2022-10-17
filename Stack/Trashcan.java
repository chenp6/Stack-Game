package Stack;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Trashcan extends Stack {
	private JPanel panel;

	public Trashcan(JPanel panel, int size) {
		super(size);
		this.panel = panel;
	}

	@Override
	public void push(Object element) {
		super.push(element);
		repaintTrashcan();
		
		if (isFull()) {
			//若stack滿	遊戲failed
			App.failed = true;
			App.setfailedGame();
		}
	}

	@Override
	public Object pop() {
		Object obj = super.pop();
		repaintTrashcan();
		return obj;
	}

	private void repaintTrashcan() {
		Utils.clearPanel(panel);
		for (int i = this.top; i >= 0; i--) {
			JLabel trashbag = new JLabel();
			panel.add(trashbag);
			trashbag.setIcon(Utils.getIcon("img/trash" + i % 2 + ".png", 120, 80));
			trashbag.setBounds((i % 5) * 60, 120 - (int) (i / 5) * 30, 140, 100);
		}
		Utils.repaintComponent(panel);

	}

}
