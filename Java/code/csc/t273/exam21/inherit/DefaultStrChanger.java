package csc.t273.exam21.inherit;
import csc.t273.exam21.inherit.sub.ExtendedStrChanger;

public class DefaultStrChanger extends StrChangerBase {
  
  @Override
  protected void append(String s) {
    this.setBase("(" + this.getCapitalDouble() + s + ")");
  }

  @Override
  public String getBase() {
    return super.getCapitalized();
  }
  
  public static void main(String[] args) {
    StrChangerBase sc = new DefaultStrChanger();
    System.out.println(sc.getBase());
    sc.setBase("b");
    System.out.println(sc.getBase());
    sc.append("b");
    System.out.println(sc.getBase());

    sc = new ExtendedStrChanger();
    System.out.println(sc.getBase());
    sc.setBase("b");
    System.out.println(sc.getBase());
    sc.append("b");
    System.out.println(sc.getBase());
  }
}
