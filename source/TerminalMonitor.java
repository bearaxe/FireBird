//Does terminal monitoring.
//This does not do input interpretation.
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

  private void prompt(){
    System.out.print(">> ");
  }

}
