//TODO: Update input scanner to respond to 1st word of every line in long inputs
import java.util.Scanner;

public class Manager{

  public static void main(String[] args) {
    if(args.length == 0){
      TestDep deps = new TestDep();
      args = deps.useHardMsg();
    }
    Printer printer = new Printer();
    printer.boxPrint(args);

    scanForInput(printer);
  }

  private static void scanForInput(Printer printer){
    Scanner input = new Scanner(System.in);
    for (prompt(); input.hasNextLine(); prompt()){
      String newMsg = input.nextLine();

      if(newMsg.length() == 0)
        continue;//skip next parts, go to next round

      if(newMsg.trim().equalsIgnoreCase("exit")){
        System.exit(0);
      }

      String[] args = newMsg.split("\\.");
      readInput(args);
      printer.boxPrint(args);
    }
  }

  private static void readInput(String[] args){
    for(String argLine : args){
      argLine = argLine.trim();
      String keyword = argLine.split(" ")[0];
      //this will eventually need to be a case statement.
      if(keyword.equalsIgnoreCase("load")){
        String fileLocation = argLine.substring(5);
        loadFile(fileLocation);
      }
    }
  }

  private static void loadFile(String fileLocation){
    System.out.println("File at " + fileLocation + " loaded!");
  }

  public static void prompt(){
    System.out.print(">> ");
  }

}
