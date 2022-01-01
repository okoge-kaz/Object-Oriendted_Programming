### 継承
親クラスの性質（メソッド、フィールド）は、（記述しなくても）子クラスで利用できる。
```java
class ChildClass extends ParentClass {
  string name; // フィールド（メンバ変数）
  ChildClass () {
    // コンストラクタ
  }
  string getName () {
    return this.name;
  }
}

public static void main() {
  
}
```

### オーバーライド

スーパークラスで定義しているインスタンスメソッドをサブクラスで変更する。

### オーバーロード

名前が同じでシグネチャが異なるメソッド

### 継承と差分プログラミング

委譲: 他のオブジェクトに機能を借りる実装方法

差分プログラミング（他の人や、自分が過去に作成したオブジェクトを部分利用することで実装コストを減少させる手法のこと）

### インタフェース

オブジェクトの外部に対するインタフェースとなるメソッドを宣言

クラスと異なる点
1. メソッド内の処理は記述しない（＝不要な継承がない）
2. フィールドは、定数（final public static）のみ
3. インスタンスを作ることはできない
4. メソッドは抽象メソッド（abstract public）のみ

### 抽象クラス

インタフェースとの違い
- 抽象メソッドだけでなく、実装をもつメソッドも定義できる
- 共通の特性はメソッドを定義
- 特性（実装）の差異がある部分は抽象メソッドに

```java
abstract class Shape {
  abstract double getArea();
  int copareTo(Shape s){
    return (int)(this.getArea() - s.getArea());
  }
  // getArea()の詳細な実装には触れないが、作っておくことでうまくいく
}
```

### Javaにおけるファイルとクラス関係

#### １つのファイルの中に複数のクラスを記述可能
- ただしpublicなクラスは１つのみ
- ファイル名 = publicなクラスの名前


### パッケージ外のクラスの利用

`import`文でパッケージ外のクラスの利用を制限

`import static`: 外部クラスのstaticメンバーへの参照を簡略化できる

```java
import static java.lang.Math.max;

public class StataticImport {
  public int calculate(int i, int j){
    return max(i, j);// Math.max(i, j)と書かなくていい
  }
}
```

### final修飾子

final修飾子 = 変更不可
クラス: 継承不可
メソッド: 継承後の上書き（オーバーライド）不可

### コーディング規約

基本CamelCaseを用いる。定数のみsnake_caseを用いる

（ケバブケースkebab-case）は、ハイフンが減算演算子

- final: 変更不可   
  - 変数に格納されているオブジェクトを変えたくない。
  - クラス・メソッドを継承・オーバーライドさせない。

- private: そのクラス内のみ参照可
  - 自分（そのクラス、クラスのオブジェクト）以外は見れない、変更できない
  - 公開する必要のない処理


### OOP2-5

オーバーライド不可 -> final修飾子 
