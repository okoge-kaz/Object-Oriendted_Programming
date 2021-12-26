import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class Main26 {
  static int a = 10;
  static String buf = null;

  public static int m1() {
    for(int i = 0; i < 10; i++) {
      a -= i;
      a /= a;
    }
    return a;
  }

  public static int m2() {
    return buf.length();
  }

  public static int m3(int b) {
    if(b < 0) {
      throw new IllegalArgumentException("For input: " + b);
    }
    return b;
  }

  public static void main(String[] args) {
    try {
      int select = Integer.parseInt(args[0]);
      switch(select) {
        case 1:
        m1();
        break;

        case 2:
        m2();
        break;

        default:
        m3(select);
      }
      FileInputStream fi = new FileInputStream("no_such_file");
      System.out.println(fi.available());
    } catch(ArrayIndexOutOfBoundsException e) {
      e.printStackTrace();
    } catch(ArithmeticException e) {
      e.printStackTrace();
    } catch(NumberFormatException e) {
      e.printStackTrace();
    } catch(NullPointerException e) {
      e.printStackTrace();
    } catch(FileNotFoundException e) {
      e.printStackTrace();
    } catch(IOException e) {
      e.printStackTrace();
    }
    System.out.println("Successfully finished");
  }
}