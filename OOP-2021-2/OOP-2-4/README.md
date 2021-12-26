# 問題2-4(基本)

`oop.ex24`には指定の範囲を順に返す`RangeGenerator`クラスと乱数を返す`RandomGenerator`クラス、およびそれらの共通のインターフェースである`Iterator`が定義されている。
この二つのクラス`RangeGenerator`と`RandomGenerator`にさらに（もう一つ定義されている）`Initializable`インターフェースを実装せよ。
`Initializable`インターフェースの意図は「`init`メソッドにより状態を初期化する」ものである。
実装されるメソッドの結果については実行例を参照せよ（特に`RangeGenerator`クラスの動きに注目する方がわかりやすいだろう）。

なお、`Iterator`インターフェースはJavaの標準ライブラリにも存在する https://docs.oracle.com/javase/jp/8/docs/api/java/util/Iterator.html が、本課題のものよりメソッドが多く、またGenericsを使った定義になっている。

### 実行例

    RangeGenerator 0 : 4
    RangeGenerator 1 : 5
    RangeGenerator 2 : 1
    RangeGenerator 3 : 2
    RangeGenerator 4 : 3
    RandomGenerator 0 : 482710
    RandomGenerator 1 : 752316106
    RandomGenerator 2 : 28523222
    RandomGenerator 3 : 307430794
    RandomGenerator 4 : 879849494
    Reset generators
    RangeGenerator 0 : 5
    RangeGenerator 1 : 1
    RangeGenerator 2 : 2
    RangeGenerator 3 : 3
    RangeGenerator 4 : 4
    RandomGenerator 0 : 752316106
    RandomGenerator 1 : 28523222
    RandomGenerator 2 : 307430794
    RandomGenerator 3 : 879849494
    RandomGenerator 4 : 430818378
