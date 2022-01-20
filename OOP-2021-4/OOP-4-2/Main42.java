import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Files;
class Main42 {
  public static void main(String[] args) {
    Path path = Paths.get(System.getProperty("user.home"), "OOPsample");
    System.out.println(Files.exists(path) && Files.isDirectory(path));
    System.out.println(Files.exists(path) && Files.isRegularFile(path));

    if(Files.exists(path)){
      System.out.println(path.toAbsolutePath() + "が存在します");
    } else {
      try {
        Files.createDirectory(path);
        System.out.println(path.toAbsolutePath() + "を作成しました");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}