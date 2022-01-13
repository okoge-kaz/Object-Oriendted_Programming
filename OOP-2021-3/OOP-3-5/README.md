# 問題3-5(発展)

Java Collection Frameworkの`HashSet`を用いて、個人番号を表す`PersonID`クラスのインスタンスを追加・検索する処理を行う。
`PersonID`クラスは二つの整数（`year`と`serial`）をフィールドとして持つ。

現在のプログラムを試すとわかるとおり、同一の個人番号を持つ`PersonID`のインスタンスが複数登録される。
個人番号は同じ表記がされるものは同一の個人番号であるため、このように判定する`PersonID`クラスの`equals`メソッドを定義する。
3-2同様、`hashCode`メソッドも定義する必要がある。
`HashSet`は「同じ`hashCode`を持つインスタンス間でのみ`equals`を用いて判定する（ことで高速化している）」ため、`hashCode`の要求を満たさない場合、`HashSet`は正常に動作しないので注意すること（`main`メソッド内ではそれを確認する部分を入れていない）。

以下の2つを実装せよ。

1. `Main35`クラスの`main`メソッドで生成されるインスタンスでは（同値のインスタンスを除いて）重複がないように`PersonID`クラスに`hashCode`を定義せよ。（参考に、`year`は2桁まで、`serial`は5桁までを想定すれば十分である）
2. `hashCode`以外`PersonID`と同じように振る舞うクラス`PersonID2`を定義し、上の`HashSet`の動きから推測して`main`メソッドでの計測が`PersonID`の場合より10倍以上**遅くなる**ように`hashCode`を定義せよ。ただし`PersonID2`の`hashCode`メソッドの実行時間は`PersonID`のそれより短いか同程度であるものとする。`equals`メソッドでのインスタンス判定を行うクラスを誤らないようにすること。

2の`hashCode`の実行時間については厳格には確かめないので、明らかに遅延させるコード、計算量が異なるコードを書かない限り気にしなくてよい。


### 実行例

    For Good case
    Add 5000 data: 1868 us
    Check 10000 data: 1513 us
    For Bad case
    Add 5000 data: 198957 us
    Check 10000 data: 656766 us

なお実行時間はあくまで参考値である。
