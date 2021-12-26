package oop.ex24;

public class RangeGenerator implements Iterator {
  int current;
  final int lower, upper;
  public RangeGenerator(int initial, int lower, int upper) {
    this.lower = lower;
    this.upper = upper;
    current = initial % (upper - lower) + lower;
  }
  public int next() {
    ++current;
    if(current > upper) current = lower;
    return current;
  }
  public void init(int number) {
    this.current = number % (upper - lower) + lower;
  }
}