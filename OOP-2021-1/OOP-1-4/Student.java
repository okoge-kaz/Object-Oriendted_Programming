public class Student extends Person {
  String id;

  Student (String name, String id) {
    this.name = name;
    this.id = id;
  }

  public String getID() {
    return id;
  }

  public void setID(String id) {
    this.id = id;
  }

  public void introduce() {
    System.out.println("My name is  " + this.name);
    System.out.println("My student ID is " + this.id);
  }
}