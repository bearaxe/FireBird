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

      if(newMsg.equalsIgnoreCase("exit")){
        System.exit(0);
      }

      String[] args = newMsg.split("\\.");
      if(args[0].split(" ")[0].equalsIgnoreCase("load")){
        String fileLocation = args[0].substring(5);
        loadFile(fileLocation);
        continue;
      }

      printer.boxPrint(args);
    }
  }

  private static void loadFile(String fileLocation){
    System.out.println("File at " + fileLocation + " loaded!");
  }

  public static void prompt(){
    System.out.print(">> ");
  }

}
