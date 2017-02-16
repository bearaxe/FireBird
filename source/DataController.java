//Controls data.
//This should delegate most work.
//This is going to be a massive stub runner of a class.
public class DataController{
  private FileParser fileParser = new FileParser();
  private QueryValidator validator = new QueryValidator();

  //no write, safe for all
  public void getQuery(String query){
    System.out.println("Received your query: " + query);
    //check query before operating
    if(validator.isValid(query)){

    }
  }

  //delete then add in place
  public void updateQuery(String query, String replacement){
    System.out.println("Received your update request for:" + query
                      +" to replace with:" + replacement);
    //check query before operating
    if(validator.isValid(query)){
      deleteData(query);
      addData(replacement);
    }
  }

  //add a batch of data
  public void loadFile(String fileLocation){
    fileParser.loadFile(fileLocation);
  }

  //save as batch of data
  public void saveFile(String fileLocation){
    fileParser.saveFile(fileLocation);
  }

  private void deleteData(String query){
    System.out.println("Pretending to delete: " + query);
  }

  private void addData(String data){
    System.out.println("Pretending to add: " + data);
  }

}
