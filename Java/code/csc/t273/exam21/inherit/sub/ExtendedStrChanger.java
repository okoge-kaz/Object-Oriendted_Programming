package csc.t273.exam21.inherit.sub;
import csc.t273.exam21.inherit.StrChangerBase;

public class ExtendedStrChanger  extends StrChangerBase{
  
  @Override
  protected void append(String s) {
    String str = this.getCapitalDouble() + s; 
    // String str = this.getLowerCase() + s;
    // String str = this.getUpperCase() + s;
    // String str = this.getDouble() + s;
    setBase("[" + str + "]");
  }
}
