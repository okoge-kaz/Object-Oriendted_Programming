package csc.t273.exam21.inherit;

public abstract class StrChangerBase {
  private String base = "";

  public StrChangerBase() {
    this.append("A");
  }

  protected abstract void append(String str);

  protected final void setBase(String str) {
    this.base = str;
  }

  public String getBase() {
    return this.base;
  }

  String getUpperCase() {
    return this.base.toUpperCase();
  }

  public String getLowerCase() {
    return this.base.toLowerCase();
  }

  private String getDouble() {
    return this.base + this.base;
  }

  protected String getCapitalized() {
    return capitalized(this.base);
  }

  protected String getCapitalDouble() {
    return capitalized(getDouble());
  }

  private static String capitalized(String str) {
    if (str.length() > 1) {
      return str.substring(0, 1).toUpperCase() + str.substring(1);
    } else {
      return str;
    }
  }
}
