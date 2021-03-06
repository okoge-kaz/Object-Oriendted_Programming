# 問題3-4(基本)

文字列の一部を特定の文字列で記述することで、テンプレートとして用いることを考える。
ここでは以下の3つの文字列を用いたテンプレートを考える。

1. `YYYY` : 年を表す（4桁を想定）
2. `MM` : 月を表す（0埋めの2桁を想定）
3. `DD` : 日を表す（0埋めの2桁を想定）

以下の条件を満たすように`oop.ex34`パッケージ内に`Replacer`クラスを定義せよ。

1. 3引数のコンストラクタ`Replacer(int, int, int)`：前から順に年、月、日を表す。
2. 1引数のメソッド`String replace(String)`：引数の文字列をテンプレートとして、テンプレート内に含まれる上に挙げた文字列を、それぞれコンストラクタで与えられた年、月、日で置き換えた文字列を返す。

これ以外にフィールドやメソッドを定義してよい（しなければ実装できない）。
`Main34`から利用するために、上のコンストラクタとメソッドは可視範囲を`public`にすること。

なお、0埋めした文字列は`String.format`メソッドで作成できる。
例えば0埋めした月（`month`は`int`）の文字列は以下のようにして得られる。
```
String s = String.format("%02d", month);
```

### 実行例

    template  : YYYY年 MM月 DD日は祝日です。
    replacer1 : 2022年 02月 23日は祝日です。
    replacer2 : 2021年 11月 03日は祝日です。

    template  : 日付はMM/DD/YYYYという表記とDD/MM/YYYYという表記を見ます。
    replacer1 : 日付は02/23/2022という表記と23/02/2022という表記を見ます。
    replacer2 : 日付は11/03/2021という表記と03/11/2021という表記を見ます。
