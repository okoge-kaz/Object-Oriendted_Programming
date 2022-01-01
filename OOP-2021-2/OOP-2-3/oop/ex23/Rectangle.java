package oop.ex23;

public class Rectangle extends Figure {
  protected double width;
  protected double height;

  public Rectangle (double width, double height) {
    this.width = width;
    this.height = height;
  }

  @Override
  public double getArea() {
    return this.height * this.width;
  }
}