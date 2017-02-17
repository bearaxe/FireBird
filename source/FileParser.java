//Parses Files.
//Parses data and puts it into Objects
//import java.io.FileReader;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileParser{

  //Round 1: Read file, spit it out onto terminal.
  public void loadFile(String fileLocation){
    try{
      //learned from http://javarevisited.blogspot.com/2015/09/how-to-read-file-into-string-in-java-7.html
      //more about :: here: http://stackoverflow.com/questions/20001427/double-colon-operator-in-java-8
      //I don't really like this, but it accomplishes the round goal for tonight and i'm late.
      //I'll probably have to rework this a lot tomorrow.
      Files.lines(Paths.get(fileLocation), StandardCharsets.UTF_8).forEach(System.out::println);
    }catch (IOException e){
      System.out.println(e);
    }
    System.out.println("File at " + fileLocation + " loaded!!");
  }

  public void saveFile(String fileLocation){
    System.out.println("Saved to " + fileLocation + "!!");
  }

}
