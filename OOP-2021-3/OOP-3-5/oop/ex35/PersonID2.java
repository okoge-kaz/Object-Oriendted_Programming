package oop.ex35;

public class PersonID2 {
  final protected int year, serial;
  final private int code;
  public PersonID2(int year, int serial) {
    this.year = year; this.serial = serial;
    code = serial * 100 + year;
  }
  @Override
  public String toString() {
    return String.format("%02dB%05d", year, serial);
  }
  @Override
  public int hashCode() {
    return code;
  }
  @Override
  public boolean equals(Object obj) {
    if(obj instanceof PersonID) {
      PersonID personId = (PersonID)obj;
      return personId.year == this.year && personId.serial == this.serial;
    }
    return false;
  }
}
