package oop.ex45;

abstract public class Value extends Expression {
  public boolean getBool() {
    throw new RuntimeException("Not bool value");
  }
  public int getNumber() {
    throw new RuntimeException("Not number");
  }
}
