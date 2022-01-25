import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

class Main44 {
  public static void main(String[] args) {

    Path path = Paths.get(args[0]);
    try {
      String content = Files.readString(path);
      String[] wordArray = content.split("[ \n]");
      String[] sentenceArray = content.split("[.:]", -1);

      // 空白文字 のみものの数を数える
      int cnt = 0;
      for(String word : wordArray){
        if(word == ""){
          cnt++;
        }
      }

      final int wordsSize = wordArray.length - cnt;
      final int sentenceSize = sentenceArray.length - 1;

      System.out.println("word num: " + wordsSize);
      System.out.println("sentence num: " + sentenceSize);

    }catch(IOException e){
      e.printStackTrace();
    }
  }
}