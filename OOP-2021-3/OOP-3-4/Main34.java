import oop.ex34.Replacer;

public class Main34 {
  public static void main(String[] args) {
    String template1 = "YYYY年 MM月 DD日は祝日です。";
    String template2 = "日付はMM/DD/YYYYという表記とDD/MM/YYYYという表記を見ます。";

    Replacer rep1 = new Replacer(2022, 2, 23);
    Replacer rep2 = new Replacer(2021, 11, 3);

    System.out.println("template  : " + template1);
    System.out.println("replacer1 : " + rep1.replace(template1));
    System.out.println("replacer2 : " + rep2.replace(template1));

    System.out.println();

    System.out.println("template  : " + template2);
    System.out.println("replacer1 : " + rep1.replace(template2));
    System.out.println("replacer2 : " + rep2.replace(template2));
  }
}
