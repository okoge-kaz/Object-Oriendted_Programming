# 問題1-1(基本)

本プログラムを実行すると（`Run` ボタンを押す、ソースコードを右クリックして`Run` を選ぶなど）と標準出力に学籍番号を表示するように `Main11.java` を変更せよ。
なお、現在の `Main11` クラスは実行すると"Hello world!"と出力する。

標準出力に文字列を出力するメソッドには `System.out.print(文字列)` （引数の文字列を表示する）、`System.out.println(文字列)` （引数の文字列を表示して改行する）、`System.out.printf(文字列,...)` （C言語のprintfとほぼ同じ）がある。
どれを使ってもよい。
なお、構文の意味だが、`System.out.println(文字列)`は `System`クラスのクラスフィールド`out`が参照するオブジェクトの`println`というメソッドを呼び出す、という意味である。
詳しくは`System`クラス（の`out`フィールド）の仕様 (https://docs.oracle.com/javase/jp/8/docs/api/java/lang/System.html#out) と（`out`フィールドのクラスである）`PrintStream`クラスの仕様 (https://docs.oracle.com/javase/jp/8/docs/api/java/io/PrintStream.html) を参照してもらいたい。
