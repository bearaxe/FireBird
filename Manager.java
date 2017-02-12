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
    //begin interactive nonsense
    Scanner cmdInput = new Scanner(System.in);
    for (prompt(); cmdInput.hasNextLine(); prompt()){
      String newMsg = cmdInput.nextLine();//.replaceAll("\n", "");

      if(newMsg.length() == 0)
        continue;//skip next parts, go to next round

      String[] args = newMsg.split("\\.");

      if (newMsg.equalsIgnoreCase("exit")){
        System.exit(0);
      }

      printer.boxPrint(args);

    }
  }

  public static void prompt(){
    System.out.print(">> ");
  }

}
