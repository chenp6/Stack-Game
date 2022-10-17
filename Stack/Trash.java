package Stack;

import javax.swing.JLabel;

public class Trash {
	public static String[] TYPES = { "一般垃圾", "一般塑膠", "鐵鋁製品", "紙類", "堆肥廚餘", "養豬廚餘" };
	public static Object[][] TRASH_LIST = {
			{ "雨傘", new Trash[] { new Trash(0, "雨傘-握把", 1), new Trash(1, "雨傘-傘布", 0), new Trash(2, "雨傘-傘骨", 2) } },
			{ "罐裝洋芋片", new Trash[] { new Trash(3, "罐裝洋芋片-蓋子", 1), new Trash(4, "罐裝洋芋片-瓶身", 3) } },
			{ "牛奶盒", new Trash[] { new Trash(5, "牛奶盒-盒體", 3) } },
			{ "泡麵碗", new Trash[] { new Trash(6, "泡麵碗-上蓋", 0), new Trash(7, "泡麵碗-紙碗", 3) } },
			{ "紙便當盒",
					new Trash[] { new Trash(10, "紙便當盒-餐盒", 3), new Trash(9, "紙便當盒-餐盒蓋", 3), new Trash(59, "紙便當盒-苦瓜", 5),
							new Trash(8, "紙便當盒-橡皮筋", 0) } },
			{ "寶特瓶", new Trash[] { new Trash(11, "寶特瓶-瓶身", 1) } },
			{ "衛生紙", new Trash[] { new Trash(12, "衛生紙-包裝", 1) } },
			{ "枯枝落葉", new Trash[] { new Trash(13, "枯枝落葉-落葉", 4) } },
			{ "盆栽", new Trash[] { new Trash(14, "盆栽-植物", 4), new Trash(15, "盆栽-土", 4) } },
			{ "高壓瓶", new Trash[] { new Trash(17, "高壓瓶-瓶身", 2), new Trash(18, "高壓瓶-瓶蓋", 1) } },
			{ "瓷碗", new Trash[] { new Trash(19, "瓷碗-碗身", 0) } },
			{ "袋裝洋芋片", new Trash[] { new Trash(20, "袋裝洋芋片-包裝", 0) } },
			{ "披薩盒", new Trash[] { new Trash(21, "披薩盒-盒子", 3), new Trash(22, "披薩盒-吃不完的披薩", 5) } },
			{ "塑膠飲料杯",
					new Trash[] { new Trash(23, "塑膠飲料杯-吸管", 0), new Trash(24, "塑膠飲料杯-杯蓋", 1),
							new Trash(25, "塑膠飲料杯-塑膠杯", 1) } },
			{ "不織布提袋", new Trash[] { new Trash(26, "不織布提袋-袋子", 0) } },
			{ "沐浴乳瓶罐", new Trash[] { new Trash(27, "沐浴乳瓶罐-壓頭", 1), new Trash(28, "沐浴乳瓶罐-塑膠瓶", 1) } },
			{ "網購紙箱", new Trash[] { new Trash(29, "網購紙箱-膠帶", 0), new Trash(30, "網購紙箱-箱體", 3) } },
			{ "養樂多", new Trash[] { new Trash(31, "養樂多-封膜", 0), new Trash(32, "養樂多-瓶身", 1) } },
			{ "報紙", new Trash[] { new Trash(33, "報紙-報紙", 3) } },
			{ "粽子", new Trash[] { new Trash(34, "粽子-粽葉", 0), new Trash(35, "粽葉-綁繩", 0) } },
			{ "早餐店紙飲料杯",
					new Trash[] { new Trash(36, "早餐店紙飲料杯-吸管", 0), new Trash(37, "早餐店紙飲料杯-封膜", 0),
							new Trash(38, "早餐店紙飲料杯-杯身", 3) } },
			{ "雨衣", new Trash[] { new Trash(39, "雨衣-伸縮繩", 0), new Trash(40, "雨衣-雨衣", 1) } },
			{ "電子發票", new Trash[] { new Trash(41, "電子發票-電子發票", 0) } },
			{ "衣架", new Trash[] { new Trash(42, "衣架-尖端保護套", 0), new Trash(43, "衣架-衣架", 2) } },
			{ "立可帶", new Trash[] { new Trash(44, "立可帶-外殼", 1), new Trash(45, "立可帶-彈簧", 2),
					new Trash(46, "立可帶-立可帶帶芯", 0) } },
			{ "水果網套", new Trash[] { new Trash(47, "水果網套-緩衝墊", 1) } },
			{ "蛤蠣", new Trash[] { new Trash(48, "蛤蠣-蛤蠣殼", 4) } }, { "口罩", new Trash[] { new Trash(49, "口罩-口罩", 0) } },
			{ "飲料罐", new Trash[] { new Trash(50, "飲料罐-鐵罐飲料", 2) } },
			{ "熱咖啡杯",
					new Trash[] { new Trash(51, "熱咖啡杯-杯蓋", 1), new Trash(52, "熱咖啡杯-紙杯", 3),
							new Trash(53, "熱咖啡杯-隔熱杯套", 3) } },
			{ "水果", new Trash[] { new Trash(54, "水果-水果果皮", 4) } }, { "肉燥", new Trash[] { new Trash(55, "肉燥-肉燥", 5) } },
			{ "小糕點", new Trash[] { new Trash(56, "小糕點-糕點", 5) } },
			{ "水煮蛋", new Trash[] { new Trash(57, "水煮蛋-蛋殼", 4), new Trash(58, "水煮蛋-蛋", 5) } },

	};
	private String name;
	private int index;
	private int type;

	public Trash(int index, String name, int type) {
		super();
		this.index = index;
		this.name = name;
		this.type = type;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public int getType() {
		return this.type;
	}

	public int getIndex() {
		return this.index;
	}

	public String getName() {
		return this.name;
	}

	public void showTrash(JLabel name, JLabel img) {
		name.setText(this.name);
		Utils.repaintComponent(name);
		img.setIcon(Utils.getIcon("img/trashComponent" + this.index + ".png", 270, 220));
		Utils.repaintComponent(img);
	}
}
