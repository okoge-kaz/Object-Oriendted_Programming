package oop.ex23;

public class Rectangle extends Figure {
  protected double width;
  protected double hight;

  public Rectangle (double width, double hight) {
    this.width = width;
    this.hight = hight;
  }

  @Override
  public double getArea() {
    return this.hight * this.width;
  }
}