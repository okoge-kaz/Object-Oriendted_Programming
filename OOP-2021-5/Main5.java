import java.util.Scanner;

class Main5 {
  public static void main(String[] args) {
    // このメソッドは好きに変更して構いません（このコメントは消してください）
    Scanner scan = new Scanner(System.in);
    while(scan.hasNextLine()) {
      // WindowsのコマンドプロンプトならCTRL+Z、Linux/UnixならCTRL+Dで終端にできます
      String line = scan.nextLine();
      System.out.println(line);
    }
  }
}
