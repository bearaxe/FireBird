//Entry point of system.
//Doesn't do much but keeps things organized.
public class Manager{

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
