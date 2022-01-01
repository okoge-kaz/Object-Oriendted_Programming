class Pointer {
  int data;
  void setData(int i){
    data = i;
  }
  int getData(){
    return data;
  }
  public static void main(String[] args) {
    Pointer a,b;
    a = new Pointer();
    a.setData(1);
    b = a;
    b.setData(2);
    System.out.println(a.getData());
    // bの値を変更したはずなのにaの値が変更されている。

    int[] array_a = new int[2];
    int[] array_b;
    array_a[0] = 0; array_a[1] = 10;
    array_b = array_a.clone();// copy
    System.out.print(array_b[0] + ",");
    array_b[0] = 2;

    System.out.print(array_b[0]+",");
    System.out.println(array_a[0]);
    // このようにすると、配列でもコピーができて、ポインタのような動作とは別にできる。

    // shallow copy or deep copy
    // 参照先は共通: コピー元と参照先のデータを共有、コピー時間は短く済む、メモリ領域は少なく済む
    // 参照先の実体まで複製: コピー元と独立にデータを扱える
    // コピーに時間がかかる。メモリ領域が多く必要
    
  }
}
