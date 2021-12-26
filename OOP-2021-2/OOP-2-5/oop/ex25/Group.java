package oop.ex25;

public class Group implements Element {
  private Element[] elems;

  public Group(Element e1, Element e2) {
    elems = new Element[2];
    elems[0] = e1; elems[1] = e2;
  }

  public Group(Element e1, Element e2, Element e3) {
    elems = new Element[3];
    elems[0] = e1; elems[1] = e2; elems[2] = e3;
  }

  public void move(int dx, int dy) {
    for(int i=0;i<this.elems.length;i++){
      this.elems[i].move(dx, dy);
    }
  }

  public void print() {
    System.out.println("[");
    for(int i=0;i<this.elems.length;i++){
      this.elems[i].print();
    }
    System.out.println("]");
  }
}