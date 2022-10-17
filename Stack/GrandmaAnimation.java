package Stack;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GrandmaAnimation extends Thread {
	private JPanel panel;
	private JLabel[] grandmas = new JLabel[] { new JLabel(), new JLabel() };
	private int appearIndex = 0;
	private Stack trashcan;
	private String side;

	public GrandmaAnimation(JPanel panel) {
		super();
		this.panel = panel;
		this.panel.setLayout(new GridLayout(1, 2, 0, 0));

		if (this.panel.getComponentCount() == 0) {
			this.panel.add(grandmas[0]);
			this.panel.add(grandmas[1]);
		} else {
			grandmas[0] = (JLabel) this.panel.getComponent(0);
			grandmas[1] = (JLabel) this.panel.getComponent(1);

		}

	}

	public GrandmaAnimation(JPanel panel, Stack trashcan) {
		this(panel);
		this.trashcan = trashcan;
	}

	public GrandmaAnimation(JPanel panel, Stack trashcan, String side) {
		this(panel, trashcan);
		this.side = side;
		if (side == "right") {
			appearIndex = 1;
		}
	}

	// push垃圾袋至垃圾桶trashcan【Stack】
	private void throwTrash() {
		// 一個垃圾袋放一個物品，一個物品可能可拆成諸多Trash【Stack】
		Object[] trashbag = ((Object[]) Utils.getRandomArrayItem(Trash.TRASH_LIST));
		// push一包垃圾袋trashcan【Stack】
		trashcan.push(new Stack((String) trashbag[0], (Trash[]) (trashbag[1])));
	}

	@Override
	public void run() {
		do {
			try {
				runARound();
				sleep(Utils.getRandomInt(5000, 10000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (!App.pass && side == "left"); // 右側則僅執行一次
	}

	public void runARound() throws InterruptedException {

		startThrow();
		sleep(500);
		walk(grandmas[appearIndex], grandmas[(appearIndex + 1) % 2]);
		sleep(500);
		if (App.pass||App.failed)
			return;
		throwTrash();
		doneThrow();
		sleep(500);
		walk(grandmas[appearIndex], grandmas[(appearIndex + 1) % 2]);
		sleep(500);
		reset();

	}

	private void startThrow() {
		grandmas[appearIndex].setIcon(Utils.getIcon("img/grandma_" + side + ".png", 157, 221));
		Utils.repaintComponent(this.panel);
	}

	private void doneThrow() {
		grandmas[appearIndex].setIcon(Utils.getIcon("img/grandma_flip_" + side + ".png", 157, 221));
		Utils.repaintComponent(this.panel);
	}

	private void walk(JLabel pre, JLabel next) {
		ImageIcon appearance = (ImageIcon) pre.getIcon();
		pre.setIcon(null);
		next.setIcon(appearance);
		Utils.repaintComponent(this.panel);

		appearIndex = (appearIndex + 1) % 2;
	}

	private void reset() {
		grandmas[0].setIcon(Utils.getIcon("img/grandma_space.png", 157, 221));
		grandmas[1].setIcon(Utils.getIcon("img/grandma_space.png", 157, 221));
		Utils.repaintComponent(this.panel);
	}

}
