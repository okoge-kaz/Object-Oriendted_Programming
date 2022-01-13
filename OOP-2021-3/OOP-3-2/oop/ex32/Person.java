package oop.ex32;

public class Person {
  private int id;
  final protected String first, last;
  public Person(String first, String last) {
    this.first = first; this.last = last;
    id = this.first.hashCode() + this.last.hashCode();
  }
  @Override
  public String toString() {
    return first + " " + last;
  }
  @Override public int hashCode() {
    return this.id;
  }
  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Person){
      Person person = (Person)obj;
      boolean response = (person.first.equals(this.first) && person.last.equals(this.last));
      return response;
    }else return false;
  }
}
