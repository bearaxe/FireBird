//Does terminal monitoring.
//This does input interpretation.
//As much as I want to, I can't call it MonitorMonitor
import java.util.Scanner;

public class TerminalMonitor{
  private DataController dataController = new DataController();

  public void scanForInput(Printer printer){
    Scanner input = new Scanner(System.in);
    for (prompt(); input.hasNextLine(); prompt()){
      String newMsg = input.nextLine();

      if(newMsg.length() == 0)
        continue;//skip next parts, go to next round

      String[] args = newMsg.split("\\.");
      dataController.readInput(args);
      printer.boxPrint(args);
    }
  }

  //this will get moved to what will be between terminalMonitor and webMonitor
  //That would imply it belongs in DataController. And it does.
  // private void readInput(String[] args){
  //   for(String argLine : args){
  //     argLine = argLine.trim();
  //     String keyword = argLine.split(" ")[0];
  //     int keySpaceLen = keyword.length()+1;
  //
  //     dataController.readCommand(keyword, keySpaceLen);
  //
  //     switch(keyword){
  //       case "exit":
  //         System.exit(0);
  //         break;
  //       case "load":
  //         dataController.loadFile(argLine.substring(keySpaceLen));
  //         break;
  //       case "update":
  //         dataController.updateQuery(argLine.substring(keySpaceLen), "Unimplemented");
  //         break;
  //       case "find":
  //         dataController.getQuery(argLine.substring(keySpaceLen));
  //         break;
  //       case "save":
  //         dataController.saveFile(argLine.substring(keySpaceLen));
  //       default:
  //         break; //do nothing, just print.
  //       }
  //     }
  //   }

  private void prompt(){
    System.out.print(">> ");
  }

}
