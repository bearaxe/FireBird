//TODO: make message borders even
//TODO: make a testing class to quarantine Dirty Code
//TODO: add text centering abilities

public class WakeUp {

    public static void main(String[] args) {
        if(args.length == 0){
          TestDep deps = new TestDep();
          args = deps.useHardMsg();
        }
        printInBox(args);
    }

    public static void printInBox(String[] messages){
      System.out.println("----------------------------------");
      for(String message : messages){
          System.out.println("|" + message + "|");
      }
      System.out.println("----------------------------------");
    }

}
