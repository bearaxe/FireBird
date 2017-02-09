//TODO: add verbose mode
//TODO: make a testing class to quarantine Dirty Code
//TODO: add maxWidth for box display
//TODO: make a preferences object that will interface with stuff like MAX_WIDTH
//BUG: trim newlines off the end
import java.util.ArrayList;

public class WakeUp {
    private static final int MAX_WIDTH = 80;
    private static ArrayList<String> outMsg = new ArrayList<String>();
    private static int longestLen = 0;

    public static void main(String[] args) {
      if(args.length == 0){
        TestDep deps = new TestDep();
        args = deps.useHardMsg();
      }
      boxPrint(args);
    }

    public static void boxPrint(String[] messages){
      processMsgs(messages);
      printMsg(formatMsg());
    }

    public static void printMsg(String finalMsg){
      String caps = "";
      for(int i=0; i<longestLen; i++){
        caps += "-";
      }

      finalMsg = "." + caps + ".\n"
                + finalMsg
                + "'" + caps + "'";

      System.out.println(finalMsg);
    }

    public static String formatMsg(){
      String lastMsg="";
      for(String string: outMsg){
        string = string.trim();
        int strLen = string.length();
        for(int i=0; i<longestLen-strLen; i++){
          string += ' ';
        }
        lastMsg += "|" + string + "|\n";
      }
      return lastMsg;
    }

    public static void processMsgs(String[] messages){
      for(String message : messages){
        if(message.length() > longestLen){
          longestLen = message.length();
        }
        outMsg.add(message);
      }
      //System.out.println("longest line is: " + longestLen);//Save for -v mode
    }
}
