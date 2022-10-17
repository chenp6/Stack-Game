/**
 * @author chenp6
 *
 */
package Stack;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.Component;

public class App {
	// push應用: GrandAnimation的throwTrash()
	// pop應用: App的popTrash()

	public static JFrame frame;
	public static boolean pass = false;
	public static boolean failed = false;
	public static int time = 0;

	private static JPanel trashcanPanel = new JPanel();
	private static Trashcan trashcan = new Trashcan(trashcanPanel, 25);
	private static JPanel rightGrandmaContainer;
	private static JLabel questionImg;
	private static JLabel questionText;
	private static Stack nowTrashbag = new Stack(1);
	private static Trash nowTrash;
	private static HashMap<String, Integer> wrongList = new HashMap<String, Integer>();

	// pop垃圾至垃圾桶trashcan【Stack】
	private static void popTrash() {
		if (nowTrashbag.isEmpty()) {// 現在的垃圾袋已空
			Stack temp = (Stack) (trashcan.pop()); // pop下一個垃圾袋
			nowTrashbag = temp;// 將剛pop出的垃圾袋作為新的【現在的垃圾袋】
		}
		Trash trash = (Trash) (nowTrashbag.pop());// pop現在垃圾袋中的下一個垃圾
		nowTrash = trash;// 將剛pop出的垃圾作為新的【現在的垃袋】
		nowTrash.showTrash(questionText, questionImg);// 顯示題目畫面
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame frame = new JFrame();
		App.frame = frame;

		App.frame.setBounds(0, 0, 1300, 650);

		App.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		homePage();
	}

	private void homePage() {
		Utils.clearPanels();
		frame.getContentPane().setLayout(null);
		JButton howToPlay = new JButton("遊戲說明");
		howToPlay.setFont(new Font("微軟正黑體", Font.PLAIN, 41));

		howToPlay.setBounds(882, 451, 316, 56);
		frame.getContentPane().add(howToPlay);

		JButton start = new JButton("開始遊戲");
		start.setFont(new Font("微軟正黑體", Font.PLAIN, 41));
		start.setBounds(882, 528, 316, 56);
		frame.getContentPane().add(start);
		JLabel pageImg = new JLabel();
		pageImg.setHorizontalAlignment(SwingConstants.CENTER);
		pageImg.setBounds(0, 11, 1283, 590);
		frame.getContentPane().add(pageImg);
		pageImg.setIcon(Utils.getIcon("img/stackHome.png", 1260, 600));
		Utils.repaintPanels();

		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					playGame();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		howToPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				story();
			}
		});

	}

	private void story() {
		Utils.clearPanels();

		frame.getContentPane().setLayout(null);

		JButton nextPage = new JButton("下一頁");
		nextPage.setFont(new Font("微軟正黑體", Font.PLAIN, 41));
		nextPage.setBounds(887, 506, 316, 56);
		frame.getContentPane().add(nextPage);
		JLabel pageImg = new JLabel();
		pageImg.setHorizontalAlignment(SwingConstants.CENTER);
		pageImg.setBounds(0, 11, 1283, 590);
		frame.getContentPane().add(pageImg);
		pageImg.setIcon(Utils.getIcon("img/stackStory.png", 1260, 600));
		Utils.repaintPanels();

		nextPage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rule1();
			}

		});
		Utils.repaintPanels();

	}

	private void rule1() {
		Utils.clearPanels();

		frame.getContentPane().setLayout(null);

		JButton nextPage = new JButton("下一頁");
		nextPage.setFont(new Font("微軟正黑體", Font.PLAIN, 41));
		nextPage.setBounds(1085, 531, 188, 56);
		frame.getContentPane().add(nextPage);
		JLabel pageImg = new JLabel();
		pageImg.setHorizontalAlignment(SwingConstants.CENTER);
		pageImg.setBounds(0, 11, 1283, 590);
		frame.getContentPane().add(pageImg);
		pageImg.setIcon(Utils.getIcon("img/stackRule01.png", 1260, 600));
		Utils.repaintPanels();

		nextPage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rule2();
			}

		});
		Utils.repaintPanels();

	}

	private void rule2() {
		Utils.clearPanels();

		frame.getContentPane().setLayout(null);

		JButton nextPage = new JButton("下一頁");
		nextPage.setFont(new Font("微軟正黑體", Font.PLAIN, 41));
		nextPage.setBounds(1095, 545, 188, 56);
		frame.getContentPane().add(nextPage);
		JLabel pageImg = new JLabel();
		pageImg.setHorizontalAlignment(SwingConstants.CENTER);
		pageImg.setBounds(0, 11, 1283, 590);
		frame.getContentPane().add(pageImg);
		pageImg.setIcon(Utils.getIcon("img/stackRule02.png", 1260, 600));
		Utils.repaintPanels();

		nextPage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					playGame();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		Utils.repaintPanels();
	}

	private static void playGame() throws InterruptedException {
		Utils.clearPanels();
		App.frame.getContentPane().setLayout(new BorderLayout());

		// upperPanel:計時器
		JPanel upperPanel = new JPanel();
		App.frame.getContentPane().add(upperPanel, BorderLayout.NORTH);
		JTextField timerText = Utils.makeTimer();
		upperPanel.add(timerText);
		TimerThread timer = new TimerThread(timerText);
		timer.start();

		// centerPanel: 按鈕區+問題顯示區
		JPanel centerPanel = new JPanel();
		App.frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 20));
		JPanel buttonPanel = new JPanel();
		centerPanel.add(buttonPanel, BorderLayout.NORTH);
		makeTypeBtn(buttonPanel);

		// 問題顯示區
		JPanel questionPanel = new JPanel();
		centerPanel.add(questionPanel);
		questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.PAGE_AXIS));
		questionText = new JLabel("");
		questionPanel.add(questionText);
		questionText.setAlignmentX(Component.CENTER_ALIGNMENT);
		questionText.setFont(new Font("微軟正黑體", Font.PLAIN, 32));
		questionText.setHorizontalAlignment(SwingConstants.CENTER);
		questionImg = new JLabel();
		questionPanel.add(questionImg);
		questionImg.setAlignmentX(Component.CENTER_ALIGNMENT);

		// lowerPanel:左阿嬤、垃圾桶區、右阿嬤
		JPanel lowerPanel = new JPanel();
		App.frame.getContentPane().add(lowerPanel, BorderLayout.SOUTH);
		lowerPanel.setLayout(new GridLayout(1, 3, 0, 0));

		// 左邊阿嬤平均5-10秒給予一個垃圾袋
		JPanel leftGrandmaContainer = new JPanel();
		lowerPanel.add(leftGrandmaContainer);
		GrandmaAnimation grandma1 = new GrandmaAnimation(leftGrandmaContainer, trashcan, "left");
		grandma1.start();

		// 中間為垃圾桶區
		lowerPanel.add(trashcanPanel);
		trashcanPanel.setLayout(null);
		// 預設5個垃圾袋
		trashcan.push("娃娃");
		for (int i = 0; i < 4; i++) {
			// 一個垃圾袋放一個物品，一個物品可能可拆成諸多Trash【Stack】
			Object[] trashbag = ((Object[]) Utils.getRandomArrayItem(Trash.TRASH_LIST));
			// 將垃圾袋push進trashcan中【Stack】
			trashcan.push(new Stack((String) trashbag[0], (Trash[]) trashbag[1]));
		}

		// 右邊阿嬤在回答錯誤時會丟一垃圾袋(於makeTypeBtn裡面設定)
		rightGrandmaContainer = new JPanel();
		lowerPanel.add(rightGrandmaContainer);

		// pop第一個垃圾袋的第一個Trash
		// 並顯示至問題區
		// 記錄其正確分類
		popTrash();

		Utils.repaintPanels();

	}

	private static void makeTypeBtn(JPanel buttonPanel) {
		for (int i = 0; i < Trash.TYPES.length; i++) {
			String type = Trash.TYPES[i];
			JButton btn = new JButton(type);
			btn.setFont(new Font("微軟正黑體", Font.PLAIN, 31));
			buttonPanel.add(btn);
			int typeIndex = i;
			btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (App.pass||App.failed)
						return;
					
					//為最後一包垃圾,若是則 pass Game
					if (trashcan.getPeak().equals("娃娃") && nowTrashbag.isEmpty()) {
						if (nowTrash.getType() != typeIndex) {//此題答錯的話
							// 新增該題與其正確答案至最後的答錯紀錄
							wrongList.put(nowTrash.getName(), nowTrash.getType());
						}
						passGame();
					} 	
					//若多餘一包垃圾,若是則還未 pass Game
					else {
						if (nowTrash.getType() != typeIndex) {// 答錯的話
							// 新增該題與其正確答案至最後的答錯紀錄
							wrongList.put(nowTrash.getName(), nowTrash.getType());
							
							// 會有右邊的阿嬤會來push一包垃圾袋入trashcan【Stack】
							GrandmaAnimation grandma2 = new GrandmaAnimation(rightGrandmaContainer, trashcan, "right");
							grandma2.start();
						}
						popTrash();// pop下一個trash
					}

				}
			});

		}
	}
	
	public static void setfailedGame() {
		failedGame();
	}
	
	private static void failedGame() {

		// 現在的垃圾桶已滿,failed Game
		App.failed = true;
		
		questionText.setText("太多垃圾了!任務失敗，整理不完!");
		questionImg.setIcon(Utils.getIcon("img/failedDoll.png", 270, 220));
		Utils.repaintComponent(questionImg);


		JButton button = new JButton("查看結果");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				endGame();// 查看結果=>結束遊戲
			}
		});
		
		Utils.clearPanel(rightGrandmaContainer);
		
		rightGrandmaContainer.setLayout(null);
		button.setBounds(0, 0, 100, 100);
		rightGrandmaContainer.add(button);
		Utils.repaintComponent(rightGrandmaContainer);
	}
	
	
	private static void passGame() {
		// 現在的垃圾袋已經清空且下一個垃圾袋(最上層為娃娃)
		App.pass = true;

		questionText.setText("找到了!阿明的娃娃!");
		Utils.repaintComponent(questionText);
		questionImg.setIcon(Utils.getIcon("img/doll.png", 270, 220));
		Utils.repaintComponent(questionImg);


		JButton button = new JButton("查看結果");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				endGame();// 查看結果=>結束遊戲
			}

		});
		Utils.clearPanel(rightGrandmaContainer);
		rightGrandmaContainer.setLayout(null);
		button.setBounds(0, 0, 100, 100);
		rightGrandmaContainer.add(button);
		Utils.repaintComponent(rightGrandmaContainer);
		trashcan.pop();// pop最後一個娃娃
	}
	

	/**
	 * End Game遊戲結束畫面
	 */
	private static void endGame() {
		Utils.clearPanels();
		String endString = "";
		if(App.pass) {
			endString = "<html>謝謝你幫阿明一起找回娃娃<br>你總共花了" + App.time + "秒</html>";
		}else {
			endString = "<html>謝謝你幫阿明一起找娃娃但垃圾太多了!實在是找不到娃娃<br>你總共花了" + App.time + "秒</html>";
		}
		
		JLabel resultLabel = new JLabel(endString);
		resultLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 33));
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(resultLabel, BorderLayout.NORTH);

		String[] title = { "答錯題目", "正確分類" }; // 標題
		DefaultTableModel tableM = new DefaultTableModel(null, title);// table內容
		JTable table = new JTable(tableM) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}// 表格不允許被編輯
		};
		table.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		table.setRowHeight(25);
		for (String key : wrongList.keySet()) {
			Object[] temp = { key, Trash.TYPES[wrongList.get(key)] };
			tableM.addRow(temp);
		}
		JScrollPane tablePane = new JScrollPane(table);// 滑動滾輪與顯示標題列
		frame.getContentPane().add(tablePane, BorderLayout.CENTER);

		resetGame();

		JButton button = new JButton("再玩一次!");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					playGame();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		frame.getContentPane().add(button, BorderLayout.SOUTH);

		Utils.repaintPanels();
	}

	private static void resetGame() {
		App.pass = false;
		App.failed = false;
		App.time = 0;

		trashcanPanel = new JPanel();
		trashcan = new Trashcan(trashcanPanel, 25);
		nowTrashbag = new Stack(1);
		wrongList = new HashMap<String, Integer>();
	}
}
