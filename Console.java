//Does terminal monitoring.
//This is a submanager that does input interpretation (for now)
import java.util.Scanner;

public class Console{
  private DataHandler dataHandler = new DataHandler();

  public void scanForInput(Printer printer){
    Scanner input = new Scanner(System.in);
    for (prompt(); input.hasNextLine(); prompt()){
      String newMsg = input.nextLine();

      if(newMsg.length() == 0)
        continue;//skip next parts, go to next round

      String[] args = newMsg.split("\\.");
      readInput(args);
      printer.boxPrint(args);
    }
  }

  private void readInput(String[] args){
    for(String argLine : args){
      argLine = argLine.trim();
      String keyword = argLine.split(" ")[0];

      switch(keyword){
        case "exit":
          System.exit(0);
          break;
        case "load":
          dataHandler.loadFile(argLine.substring(5));
          break;
        case "update":
          dataHandler.updateData(argLine.substring(7));
          break;
        case "find":
          dataHandler.getData(argLine.substring(5));
          break;
        case "save":
          dataHandler.saveFile(argLine.substring(5));
        default:
          break; //do nothing, just print.
      }
    }
  }

  private void prompt(){
    System.out.print(">> ");
  }

}
