import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

class Main41 {
  public static void main(String[] args) {
    Path output = Paths.get("output.txt");

    try(BufferedReader reader = Files.newBufferedReader(output);
        BufferedWriter writer = Files.newBufferedWriter(output, StandardOpenOption.APPEND)){

          ArrayList<String> stringArray = new ArrayList<>();

          for(String line = reader.readLine(); line != null; line=reader.readLine()){
            stringArray.add(line);
          }

          for(String targetString : args){
            if(stringArray.indexOf(targetString) == -1){
              System.out.println(targetString);
              stringArray.add(targetString);
              writer.write(targetString);
              writer.newLine();
            }
          }
        } catch (NoSuchFileException error) {
          try{
              Files.createFile(output);
              try(BufferedReader reader = Files.newBufferedReader(output);
              BufferedWriter writer = Files.newBufferedWriter(output, StandardOpenOption.APPEND)){

                ArrayList<String> stringArray = new ArrayList<>();

                for(String line = reader.readLine(); line != null; line=reader.readLine()){
                  stringArray.add(line);
                }

                for(String targetString : args){
                  if(stringArray.indexOf(targetString) == -1){
                    System.out.println(targetString);
                    stringArray.add(targetString);
                    writer.write(targetString);
                    writer.newLine();
                  }
                }
              }catch (IOException e) {
                e.printStackTrace();
              }
          } catch(IOException e) {
            e.printStackTrace();
          }
        } catch (IOException error) {
          error.printStackTrace();
        }
  }
}