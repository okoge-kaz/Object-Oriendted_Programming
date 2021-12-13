# 問題1-3(基本)

`Main13` クラスを実行すると実行時引数の数を出力し、それに続いて各行に「引数の番号と引数」実行例のように一つずつ表示するよう `main` メソッドを変更せよ。
配列の範囲外アクセスによる例外が送出されないようにすること。（初期の`Main13`は何も引数を与えないと範囲外アクセスによる例外 `ArrayIndexOutOfBoundsException` が送出される）

IntelliJ IDEAではファイルを右クリックし、`Modify Run Configuration`を選んだ画面で`Program arguments`の箇所に実行時引数を設定できる。

文字列を出力するためのメソッドは1-1で説明してるが、複数の文字列を扱う場合には文字列に対しては`printf`メソッドで`%s`指定子を用いる他、文字列と他の要素（文字列、`int`など）を加算すると連結した文字列を作成できる（例えば`Main13`の3行目）ので、適宜利用するとよい。



### 実行例
    > java Main13
    The number of arguments: 0
    > java Main13 hoge
    The number of arguments: 1
    args[0] : hoge
    > java Main13 hoge fuga piyo
    The number of arguments: 3
    args[0] : hoge
    args[1] : fuga
    args[2] : piyo

この実行例はシェルから実行した場合の表示になる。
`>` はシェルの入力用プロンプトを表しており、その後ろがユーザが打ち込んだコマンドである。
`java`はJavaで書かれたプログラムを動かすためのコマンド、`Main13`は「プログラム開始時に実行される`main`メソッドが実装されたクラス」、残り（二つ目なら`hoge`、三つ目なら`hoge`と`fuga`と`piyo`）は実行時引数を表している。

