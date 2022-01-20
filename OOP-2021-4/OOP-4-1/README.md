# 問題4-1 (基本)

以下の挙動を行う`main`メソッドを`Main41`クラスに実装せよ。

1. `output.txt`というファイルからすべての行を読み込む。（ファイルが存在しない場合は何も入っていなかったものと考える）
2. `output.txt`を追記モードで開く。ファイルがなければ作成する。
3. 実行時引数のすべてについて、以下の処理をする
    - 引数が1で読み込んだ文字列に含まれないならばそれを標準出力に表示しつつ`output.txt`に1行で追記する。標準出力およびファイルへの追記で改行を忘れないこと。
    - 1で読み込んだ文字列に含まれる場合は何も表示せず、追記もしない。

2のファイルの書き込みはブロックを抜けたら自動で`close`されるようにtry-with-resource構文を用いること（1については特に制限しない）。
なお、実行時引数はすべてasciiの範囲を想定する。
また、実行時引数はすべて異なるものとする。（同じものが含まれてもよいように拡張してもよいが、特に加点等は行わない）

ファイルへの追記については、例えば https://docs.oracle.com/javase/jp/8/docs/api/java/io/FileWriter.html#FileWriter-java.io.File-boolean- を利用するか、他の方法を用いれば良い。
`main`メソッド以外にメソッドやフィールドを追加しても良い。

### 実行例
最初は`output.txt`は存在しないとする。
以下はターミナル上で実行した際の様子を示している。`>`から始まる行は実行するコマンドを表しており、それ以外の行はプログラムの出力である。
IntelliJでは、`java`は第1回演習で説明した実行時引数の設定によって`cat`コマンドは対応するファイルを開いて中身を見ることに対応する。

    > java Main hoge piyo
    hoge
    piyo
    > cat output.txt
    hoge
    piyo
    > java Main hoge fuga piyo
    fuga
    > cat output.txt
    hoge
    piyo
    fuga
    > java Main foo
    foo
    > cat output.txt
    hoge
    piyo
    fuga
    foo
    > java Main foo fuga hoge
    > cat output.txt
    hoge
    piyo
    fuga
    foo

