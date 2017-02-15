//Handles data.
//This should delegate most work.
//This is going to be a massive stub runner of a class.
public class DataHandler{

  public void loadFile(String fileLocation){
    System.out.println("File at " + fileLocation + " loaded!");
  }

  public void saveFile(String fileLocation){
    System.out.println("Saved to " + fileLocation + "!");
  }

  public void getData(String query){
    System.out.println("Received your query: " + query);
  }

  public void updateData(String query){
    System.out.println("Received your update request for:" + query);
  }

}
