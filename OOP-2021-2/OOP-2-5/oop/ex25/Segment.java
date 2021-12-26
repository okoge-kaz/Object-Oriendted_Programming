package oop.ex25;

public class Segment implements Element {
  private int startX, startY, endX, endY;

  public Segment(int startX, int startY, int endX, int endY) {
    this.startX = startX;
    this.startY = startY;
    this.endX = endX;
    this.endY = endY;
  }

  public void move(int dx, int dy){
    startX += dx; endX += dx;
    startY += dy; endY += dy;
  }

  public void print() {
    System.out.println("Segment: (" + this.startX + ", " + this.startY + ")-(" + this.endX + ", " + this.endY + ")");
  }
}