package oop.ex34;

public class Replacer {
  private final int year, month, day;

  public Replacer(int year, int month, int day) {
    this.year = year; this.month = month; this.day = day;
  }
  public String replace(String template) {
    template = template.replace("YYYY", "" + this.year);
    template = template.replace("MM", "" + format(this.month));
    template = template.replace("DD", "" + format(this.day));
    return template;
  }
  private String format(int number) {
    String res = "" + number;
    if(res.length() >= 2){
      return res;
    }
    return "0" + res;
  }
}
