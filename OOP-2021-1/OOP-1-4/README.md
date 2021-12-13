# 問題1-4(発展)

## Personの実装

まず、`Person.java` に定義された `Person` クラスに以下を追加せよ。

1. `String`型のフィールド`name`: 初期値は`"name"`とする
2. メソッド`getName`: 無引数で、フィールドの`name`を返すメソッド
3. メソッド`setName`: `String`型の引数`name`をとり，それをフィールドの`name`に代入するメソッド（返し値は`void`とする）

フィールドと引数が同名である場合その名前は引数を指すが、`this.name`のように`this`を明示することでフィールドを指すことができる。

## 実行例
`Main14`クラスの最初のコメントアウトを外して実行すると以下のように表示される。

    Name: name
    Name: Taro


## Studentの実装

次に、`Person`を継承したクラス `Student` を `Student.java` に定義し、以下のコンストラクタ、フィールド、メソッドを定義せよ。

1. `String` 型のフィールド `id`
2. コンストラクタ：`String` 型の `name` と `id` を引数とし、フィールド `name` と `id` を引数で初期化する
3. メソッド`getID`：`id` を返す無引数メソッド
4. メソッド`setID`：`String`型の引数`id`をとり、フィールドの`id`に代入するメソッド（返し値は`void`）
5. メソッド`introduce`：無引数で，`name` と `id` の内容を標準出力に表示するメソッド（書式は実行例を参照）

注意：`Student` に再度 `name` をフィールドとして宣言しないこと。

### 実行例
`Main14`クラスの後ろのコメントアウトを外すと上の実行例に続けて以下のように表示される。

    Name: Toko
    ID: 19B01234
    My name is Moriguchi
    My student ID is 03B24949
