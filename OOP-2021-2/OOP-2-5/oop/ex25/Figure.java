package oop.ex25;

public abstract class Figure implements Element {
  protected int x, y;

  public void move(int dx, int dy) {
    this.x += dx;
    this.y += dy;
  }
}
