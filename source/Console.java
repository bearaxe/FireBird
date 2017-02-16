//Does terminal monitoring.
//This is a submanager that does input interpretation (for now)
//I guess with the rename, this makes it a monitor. TerminalMonitor?
import java.util.Scanner;

public class Console{
  private DataController dataController = new DataController();

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
      int keySpaceLen = keyword.length()+1;

      switch(keyword){
        case "exit":
          System.exit(0);
          break;
        case "load":
          dataController.loadFile(argLine.substring(keySpaceLen));
          break;
        case "update":
          dataController.updateQuery(argLine.substring(keySpaceLen), "Unimplemented");
          break;
        case "find":
          dataController.getQuery(argLine.substring(keySpaceLen));
          break;
        case "save":
          dataController.saveFile(argLine.substring(keySpaceLen));
        default:
          break; //do nothing, just print.
      }
    }
  }

  private void prompt(){
    System.out.print(">> ");
  }

}
