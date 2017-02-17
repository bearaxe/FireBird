//Controls data.
//This should delegate most work.
//This is going to be a massive stub runner of a class.
public class DataController{
  private FileParser fileParser = new FileParser();
  private QueryValidator validator = new QueryValidator();

  public void readInput(String[] args){
    for(String argLine : args){
      argLine = argLine.trim();

      String[] words = argLine.split(" ");
      String keyword = words[0];
      String argument = "";

      if(words.length > 1){
        argument = argLine.substring(keyword.length()+1);
      }//chill, there is no possible single word command that needs arguments.
      doInput(keyword, argument);
    }
  }

  private void doInput(String keyword, String argument){
    switch(keyword){
      case "exit":
        System.exit(0);
        break;
      case "load":
        loadFile(argument);
        break;
      case "update":
        updateQuery(argument);
        break;
      case "find":
        getQuery(argument);
        break;
      case "save":
        saveFile(argument);
      default:
        break; //do nothing, just print.
    }
  }

  //no write, safe for all
  private void getQuery(String query){
    System.out.println("Received your query: " + query);
    //check query before operating
    if(validator.isValid(query)){

    }
  }

  //delete then add in place
  private void updateQuery(String query){
    //will need to parse query out.
    System.out.println("Received your update request for:" + query);
    //check query before operating
    if(validator.isValid(query)){
      deleteData(query);
      addData(query);
    }
  }

  //add a batch of data
  private void loadFile(String fileLocation){
    fileParser.loadFile(fileLocation);
  }

  //save as batch of data
  private void saveFile(String fileLocation){
    fileParser.saveFile(fileLocation);
  }

  private void deleteData(String query){
    System.out.println("Pretending to delete: " + query);
  }

  private void addData(String data){
    System.out.println("Pretending to add: " + data);
  }

}
