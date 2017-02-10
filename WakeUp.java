//TODO: add verbose mode
//TODO: make a testing class to quarantine Dirty Code
//TODO: make a preferences object that will interface with stuff like MAX_WIDTH
//TODO: Fix the names of these functions to describe their effect better
//BUG: trim newlines off the end
import java.util.ArrayList;

public class WakeUp {
    private static final int MAX_WIDTH = 78;
    private static ArrayList<String> outMsg = new ArrayList<String>();
    private static int longestLen = 0;

    public static void main(String[] args) {
      if(args.length == 0){
        TestDep deps = new TestDep();
        args = deps.useHardMsg();
      }
      boxPrint(args);
    }

    //Stub runner, keeps code clean/easy to read
    public static void boxPrint(String[] messages){
      processMsgs(messages);
      printMsg(formatMsg());
    }

    //This prepares message for formatting and determines width of print box
    public static void processMsgs(String[] messages){
      for(String message : messages){
        int mesLen = message.length();
        if(mesLen < longestLen){
          outMsg.add(message);
        }else{
          if(mesLen < MAX_WIDTH){
            longestLen = mesLen;
            outMsg.add(message);
          }else{//worst case: have to break up string
            longestLen = MAX_WIDTH;
            breakString(message);
          }
        }
      }
    }

    //This breaks a string longer than MAX_WIDTH into appropriately sized substrings
    private static void breakString(String longStr){
      int i = 0;
      while(i < longStr.length()){
        outMsg.add(longStr.substring(i, Math.min(i + MAX_WIDTH, longStr.length())));
        i += MAX_WIDTH;
      }
    }

    //This adds spacing to each line with respect to longest String
    public static String formatMsg(){
      String formattedMsg = "";
      for(String string: outMsg){
        string = string.trim();
        int strLen = string.length();
        for(int i=0; i<longestLen-strLen; i++){
          string += ' ';
        }
        formattedMsg += "|" + string + "|\n";
      }
      return formattedMsg;
    }

    //This what actually does the formatting
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

}
