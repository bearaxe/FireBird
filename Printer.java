//TODO: add verbose mode
//TODO: make a testing class to quarantine Dirty Code
//TODO: make a preferences object that will interface with stuff like MAX_WIDTH
//TODO: Fix the names of these functions to describe their effect better
//BUG: trim newlines off the end
import java.util.ArrayList;

public class Printer {
    private final int MAX_WIDTH = 78;
    private ArrayList<String> outMsg = new ArrayList<String>();
    private int longestLen = 0;

    //Stub runner, keeps code clean/easy to read
    public void boxPrint(String[] messages){
      processMsgs(messages);
      printMsg();
    }

    //This prepares message for formatting and determines width of print box
    private void processMsgs(String[] messages){
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
    private void breakString(String longStr){
      int i = 0;
      while(i < longStr.length()){
        outMsg.add(longStr.substring(i, Math.min(i + MAX_WIDTH, longStr.length())));
        i += MAX_WIDTH;
      }
    }

    //This adds spacing to each line with respect to longest String
    private String formatContent(){
      String content = "";
      for(String string: outMsg){
        string = string.trim();
        int strLen = string.length();
        for(int i=0; i<longestLen-strLen; i++){
          string += ' ';
        }
        content += "|" + string + "|\n";
      }
      return content;
    }

    private String formatBorders(String midSection){
      String caps = "";
      for(int i=0; i<longestLen; i++){
        caps += "-";
      }

      String finalMsg = "." + caps + ".\n"
                        + midSection
                        + "'" + caps + "'";

      return finalMsg;
    }

    //This what actually does the formatting
    private void printMsg(){
      String midSection = formatContent();
      String output = formatBorders(midSection);
      System.out.println(output);
    }

}
