//Handles data.
//This should delegate most work.
//This is going to be a massive stub runner of a class.
public class DataHandler{

  public void getData(String query){
    System.out.println("Received your query: " + query);
  }

  public void updateData(String query, String replacement){
    System.out.println("Received your update request for:" + query
                      +" to replace with:" + replacement);
  }

}
