//Entry point of system.
//Doesn't do much but launch the system.
public class Launcher{

  public static void main(String[] args) {
    if(args.length == 0){
      TestDep deps = new TestDep();
      args = deps.useHardMsg();
    }
    Printer printer = new Printer();
    Console terminal = new Console();

    printer.boxPrint(args);
    terminal.scanForInput(printer);
  }

}
