package oop.ex23;

public class Circle extends Figure {
  protected double radius;

  public Circle (double radius) {
    this.radius = radius;
  }

  @Override
  public double getArea() {
    return Math.PI * this.radius * this.radius;
  }
}