import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class DrawDemo extends Canvas implements ActionListener {
	/**
	 * 図形を管理する Map(データ構造)
	 */
	public HashMap<String, Figure> figList;

	/**
	 *  コンストラクタ
	 */
	public DrawDemo() {
		figList = new HashMap<String, Figure>();
		this.initGUI();
	}

	/**
	 * GUI初期化 : 講義範囲外なので無視してOK
	 */
	public void initGUI() {
		Frame f = new Frame("Welcome to Drawing Demo");
		TextField userInput = new TextField("Input draw command");
		f.addWindowListener(new WindowAdapter() { // ウィンドウを閉じると終了
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.setLayout(new BorderLayout()); // ウィンドウ内の部品の配置
		f.setSize(800, 600);
		f.add("North", userInput);
		f.add("Center", this);
		userInput.addActionListener(this); // テキストフィールドのリスナ設定
		f.setVisible(true); // ウィンドウを見せる
	}

	/**
	 * GUI描画コマンド ： いつどこで呼び出されるかは講義範囲外なので，
	 * 理解できなくて構いません．描画対象のdrawを呼ぶ方法に注意！
	 */
	@SuppressWarnings("rawtypes")
	public void paint(Graphics g) { // figList中にある図形を再描画時に描画
		Iterator itr = figList.keySet().iterator(); // 反復子
		while (itr.hasNext()) {
			Figure f = figList.get(itr.next());
			f.draw(g); // 各図形インスタンスの描画メソッドを呼ぶ
		}
	}

	/**
	 * GUIイベント処理コマンド (ActionListnerインタフェースの実装)
	 * ActionListnerは講義範囲外なので無視してOK
	 * GUI中のテキストフィールドに文字が入力され Enter が押されるたびに起動します.
	 * @param e - GUIイベント
	 */
	public void actionPerformed(ActionEvent e) { // 入力完了時の処理
		String str = ((TextField) e.getSource()).getText(); // 入力された文字列
		this.executeCommand(str); // コマンドを実行
	}

	/**
	 * 入力されたコマンドを実行
	 * @param cmdStr ー コマンド文字列
	 */
	public void executeCommand(String cmdStr) {
		// Scannerを生成．指定した文字列を単語単位で分割・読み込みしてくれる
		Scanner kb = new Scanner(cmdStr);
		Figure fig; // 作業用変数
		int x, y;

		String command = kb.next(); // 最初のトークン(コマンドのはず)読み込み
		if (command.equals("create")) { // create = 新しい図形
			String figType = kb.next(); // 図形のタイプを読み込み
			if (figType.equals("circle")) {
				fig = new Circle();
			} else if (figType.equals("triangle")) {
				fig = new Triangle();
			} else if (figType.equals("rectangle")) {
				fig = new Rectangle();
			} else { // 知らない図形タイプ
				fig = null;
				System.out.println("Unknown figure type : " + figType);
			}
			if (fig != null) { // インスタンスを生成したらparseメソッドに
				fig.parse(kb); // Scannerを渡して残りのパラメタを処理
				figList.put(fig.getName(), fig); // リストに図形を登録
			}
		} else if (command.equals("move")) { // 既存の図形を移動?
			String name = kb.next(); // 図形の名前を読み込み
			fig = figList.get(name); // 図形リストを検索
			if (fig == null) {
				System.out.println("Couldn't find " + name);
			} else { // 移動量を読み込んでmoveメソッドを呼ぶ
				x = kb.nextInt();
				y = kb.nextInt();
				fig.move(x, y);
			}
		} else if (command.equals("delete")) { // 既存の図形を削除?
			String name = kb.next(); // 図形の名前を読み込み
			if (figList.get(name) != null) { // あれば削除
				figList.remove(name);
			} else {
				System.out.println("Couldn't find " + name);
			}
		} else if (command.equals("clear")) { // 画面クリア?
			figList.clear(); // 図形リストをクリア
		} else if (command.equals("exit")) { // プログラム終了?
			System.exit(0);
		} else {
			System.out.println("Unknown command :" + command);
		}
		repaint(); // Canvasクラスのメソッド
	}

	// コマンドラインで java DrawDemo で実行されるのはこっちのmainメソッド
	public static void main(String[] args) {
		new DrawDemo(); // DrawDemoのインスタンスを生成
           // サンプルとして3つのFigureを作成
        dd.executeCommand("create circle 100 100 100 c0");
        dd.executeCommand("create triangle 100 100 0 200 200 200 t0");
        dd.executeCommand("create rectangle 100 300 200 200 r1");
	}
}

abstract class Figure {
	int x, y; // 重心の(x,y)座標
	String name; // 図形の名前

	// 名前を返すための共通実装
	public String getName() {
		return name;
	} 

	// 以下抽象メソッド．これらは派生クラスで実装される
	abstract void parse(Scanner s); 
	abstract void move(int dx, int dy); 
	abstract void draw(Graphics g); 
}

class Circle extends Figure {
	int r;

	@Override
	void parse(Scanner s) { // "create circle ↓x y r name"次は↓から読み込み
		this.x = s.nextInt(); // 重心：親のFigureクラスのフィールド
		this.y = s.nextInt();
		this.r = s.nextInt(); // 半径：Circleクラスのフィールド
		this.name = s.next(); // 名前：親のFigureクラスのフィールド
	}

	@Override
	void move(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}

	@Override
	void draw(Graphics g) {
		g.drawOval((x - r), (y - r), (2 * r), (2 * r));
	}
}

abstract class Polygon extends Figure { 
	/**
	 * 頂点x座標，y座標の配列．あまり良い実装ではない 
	 */
	int[] xs, ys; 

	@Override
	void move(int dx, int dy) {
		this.x += dx;
		this.y += dy;
		for (int i = 0; i < xs.length; i++) {
			this.xs[i] += dx;
			this.ys[i] += dy;
		}
	}

	@Override
	void draw(Graphics g) {
		g.drawPolygon(xs, ys, xs.length);
	}
}

class Triangle extends Polygon {

	/**
	 * 3つの点を指定して描画する．
	 * 重心は計算して設定していることに注意
	 */
	@Override
	void parse(Scanner s) { // "create triangle x1 y1 x2 y2 x3 y3 name"
		this.xs = new int[3];
		this.ys = new int[3];
		this.xs[0] = s.nextInt();
		this.ys[0] = s.nextInt();
		this.xs[1] = s.nextInt();
		this.ys[1] = s.nextInt();
		this.xs[2] = s.nextInt();
		this.ys[2] = s.nextInt();
		this.name = s.next();
		this.x = (xs[0] + xs[1] + xs[2]) / 3;
		this.y = (ys[0] + ys[1] + ys[2]) / 3;
	}
}

class Rectangle extends Polygon {
	
	/**
	 * rectangle の幅と高さ．
	 * この実装では，4つの頂点ではなく， 重心と幅，高さで図形を規定
	 */
	int w, h; 

	@Override
	void parse(Scanner s) { // "create rectangle x y w h name"
		this.xs = new int[4];
		this.ys = new int[4];
		this.x = s.nextInt();
		this.y = s.nextInt();
		this.w = s.nextInt();
		this.h = s.nextInt();
		this.name = s.next();
		this.xs[0] = x - w / 2;
		this.ys[0] = y - h / 2;
		this.xs[1] = x + w / 2;
		this.ys[1] = y - h / 2;
		this.xs[2] = x + w / 2;
		this.ys[2] = y + h / 2;
		this.xs[3] = x - w / 2;
		this.ys[3] = y + h / 2;
	}
}
