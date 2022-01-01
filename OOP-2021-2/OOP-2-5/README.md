# 問題2-5(発展)

以下のクラスやインターフェースを定義し、`Main25`クラスの`main`メソッドが実行例の通りに動くようにせよ。
以下座標系は整数での指定を前提とするので、`int`を用いる。
なお、指定されたクラスとメソッド（コンストラクタ含む）については全て`public`を指定し、フィールドについては全て`protected`を指定すること。
また、各ファイルについては適切にパッケージ指定を行うこと（位置を変更してはならない）。

1. interface `Element` : 画面描画可能な要素を表すインターフェース。抽象メソッドとして要素の移動を表すメソッド `void move(int dx, int dy)`と描画を表すメソッド`void print()`を持つ。
2. abstract class `Figure` : 基準となる座標を持つ要素を表す抽象クラス。`Element`を実装する。フィールドとして`x`座標と`y`座標を持つ。また`move`メソッドを実装し、引数をそれぞれの座標に加えることで実現する。この`move`メソッドはオーバーライド不能になるように実装すること。`print`メソッドは実装しない。
3. class `Circle` : 円を表すクラス。`Figure`を継承する。フィールドとして半径`r`を持つ（これも`int`とする）。コンストラクタは`Circle(int x, int y, int r)`とし、`x`や`y`は`Figure`で定義されたフィールド`x`と`y`の初期化に、`r`をフィールド`r`の初期化に用いる。`print`メソッドは文字列として円であることと中心座標、半径`r`を表示する。フォーマットについては実行例を参照せよ。
4. class `Segment` : 線分を表すクラス。`Element`を実装する。フィールドとして始点の座標`startX`と`startY`、終点の座標`endX`と`endY`を持つ。コンストラクタは`Segment(int startX, int startY, int endX, int endY)`とし、それぞれの引数は対応するフィールドの初期化に用いられる。`move`メソッドは始点と終点それぞれに座標を加える。`print`メソッドは文字列として始点座標と終点座標を表示する。フォーマットについては実行例を参照せよ。
5. class `Group` : 複数の`Element`を一つの`Element`として扱うクラス。`Element`を実装する。フィールドとして`Element`の配列`elems`を持つ。コンストラクタは2種類あり、それぞれ`Group(Element e1, Element e2)`、`Group(Element e1, Element e2, Element e3)`となっている。コンストラクタでは要素数2（3）の配列を作り、`e1`と`e2`（と`e3`）を格納して`elems`に代入する。`move`メソッドは`elems`の各要素へ`move`メソッドを呼び出すことで実現し、`print`は最初と最後に`[`と`]`を表示し、その間で各要素の`print`を呼び出す（詳しくは実行例を参照せよ）。


### 実行例

    Segment: (300, 200)-(400, 300)

    Circle : (300, 300), r=50

    [
    Segment: (250, 250)-(350, 350)
    Circle : (300, 300), r=50
    ]

    [
    [
    Segment: (250, 250)-(350, 350)
    Circle : (300, 300), r=50
    ]
    Circle : (300, 300), r=30
    Segment: (350, 250)-(250, 350)
    ]

    [
    [
    Segment: (-50, 0)-(50, 100)
    Circle : (0, 50), r=50
    ]
    Circle : (0, 50), r=30
    Segment: (50, 0)-(-50, 100)
    ]