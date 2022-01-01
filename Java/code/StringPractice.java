class StringPractice {
  public static void main(String[] args){
    String x = "abc"; String y = "ab";
    y += "c";
    if(x == y){
      System.out.println("Same!");
    }else{
      System.out.println("Not Same!");
    }
    // Not Same
    System.out.println(x.equals(y));
    // true
    // Stringはオブジェクトなので
    
  }
}
