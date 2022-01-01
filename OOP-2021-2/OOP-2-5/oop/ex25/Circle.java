package oop.ex25;

public class Circle extends Figure {
  protected int r;
  public Circle (int x, int y, int r) {
    this.x = x;
    this.y = y;
    this.r = r;
  }
  public void print () {
    System.out.println("Circle : (" + this.x + ", " + this.y + "), r=" + this.r);
  }
}
