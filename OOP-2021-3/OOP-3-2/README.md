# 問題3-2(基本)

個人を表す `Person` クラスに `equals` メソッドを定義し、「同一の姓名であれば`true`を返し、そうでなければ`false`を返す」ようにせよ。
なお、本問題では同姓同名の人は考えないものとする。

`equals`メソッドを上書きする場合`hashCode`メソッドも上書きする必要がある（`equals`メソッドの仕様 https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Object.html#equals-java.lang.Object- および `hashCode`の仕様 https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Object.html#hashCode-- を参照）ため、こちらも上書きせよ。
`hashCode`の要求は以下のようになっている。

1. `equals`が`true`を返す二つのオブジェクトは`hashCode`が同じ値を返さなければならない。
2. `equals`が`false`を返すからと言って、`hashCode`が異なる値を返す必要はない。

本課題での`hashCode`は上の2点を守っていれば良い（つまり`equals`で`true`を返す二つのインスタンスは必ず同一の`hashCode`を返すが他はどうでもよい）ものとする。

なお、`equals`では引数が`Person`クラスのインスタンスであるかを判定しなければならないが、これは`instanceof`演算子によって実現できる（`o instanceof Person`で「`o`が`Person`クラス（またはそのサブクラス）のインスタンスか」が`boolean`として得られる）。
キャストの失敗を例外`ClassCastException`をキャッチすることで検出する方法もあるが、一般的とは言えない。
また、`hashCode`の要求の意図については問題3-5を参照せよ。


### 実行例
    Sosuke Moriguchi =? So Mori : false
    Sosuke Moriguchi =? So Moriguchi : false
    Sosuke Moriguchi =? Sosuke Mori : false
    Sosuke Moriguchi =? Sosuke Moriguchi : true
    2126622933
    2126622933

下二行はあくまで例であり、一致していれば問題ないことに注意。
