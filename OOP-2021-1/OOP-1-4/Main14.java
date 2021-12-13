class Main14 {
  public static void main(String[] args) {
    Person p = new Person();
    // 以下はPersonのフィールドとメソッドの実装後コメントアウトを外す
    System.out.println("Name: " + p.getName());
    p.setName("Taro");
    System.out.println("Name: " + p.getName());
    
    // 以下はStudentの実装後コメントアウトを外す
    Student s = new Student("Toko", "20B01234");
    System.out.println("Name: " + s.getName());
    System.out.println("ID: " + s.getID());
    s.setName("Moriguchi");
    s.setID("03B24949");
    s.introduce();
  }
}