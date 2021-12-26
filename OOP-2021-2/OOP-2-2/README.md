# 問題2-2(基本)

`Ticket`クラスは予約番号を作るためのクラスであり、クラス内で使用中の番号かどうかを管理している。
`Ticket.java` 内のフィールドに `static` および `final` を適切に付与する（またはどちらも付与しない）ことで、`Main22` クラスがコンパイルでき、その`main`メソッドを実行すると実行例になるようにせよ。
さらに`Main22`でコメントアウトされた部分を有効にする（コメントでなくす）とコンパイルエラーが起きるようにせよ。

なお、`Ticket`クラスのメソッドは全てインスタンスメソッドであり、また継承によるオーバーライドについては考えないため、メソッドに上記のキーワードを付与する必要はない。
`Main22` クラスを編集してはならないものとする。


### 実行例

    Max Reservation number is 10
    Failed to reserve number : -1
    Succeed to reserve number : 0
    Succeed to reserve number : 1
    Succeed to reserve number : 2
    Failed to reserve number : 3
    Succeed to reserve number : 4
    Failed to reserve number : 5
    Succeed to reserve number : 6
    Succeed to reserve number : 7
    Succeed to reserve number : 8
    Succeed to reserve number : 9
    Failed to reserve number : 10
