//Handles data.
//This should delegate most work.
//This is going to be a massive stub runner of a class.
//If data handler handles data, data files should report to datahandler.
public class DataHandler{
  private FileHandler fileHandler = new FileHandler();

  public void getData(String query){
    System.out.println("Received your query: " + query);
  }

  public void updateData(String query, String replacement){
    System.out.println("Received your update request for:" + query
                      +" to replace with:" + replacement);
  }

  public void loadFile(String fileLocation){
    //System.out.println("File at " + fileLocation + " loaded!");
    fileHandler.loadFile(fileLocation);
  }

  public void saveFile(String fileLocation){
    //System.out.println("Saved to " + fileLocation + "!");
    fileHandler.saveFile(fileLocation);
  }

}
