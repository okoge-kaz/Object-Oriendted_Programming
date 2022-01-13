package oop.ex33;

public class Circle extends Figure {
  public final int r;

  @Override
  public String toString() {
    return super.toString() + "-rad:" + r;
  }

  // overload
  public Circle() {
    // 0 args
    this.r = 1;
  }
  public Circle(int r) {
    // 1 args
    this.r = r;
  }
  public Circle(int x, int y) {
    // 2 args
    super(x, y);
    this.r = 1;
  }
  public Circle(int x, int y, int r) {
    // 3 args
    super(x, y);
    this.r = r;
  }
}
