/**
 * Directly interacts with the storage Text file allows user to save vehciles to the text file
 * Have issue with retreiving vehicles back from the file after the program has been closed 
 * Issue has been isolated to the _vehicleList ArrayList not being passed over to the DeliveryVehicleContoller Class
 * @author Michael O Meara Fearghal O Sullivan Conor Ryan
 * @version 1
 */

import java.util.*;
import java.lang.*;
import java.io.*; //file manipulation classes
import java.nio.file.Files; //file manipulation classes
import java.nio.file.Paths; //file manipulation classes
import java.nio.charset.*; //file manipulation classes


public class VehicleFileParser {
    
    String _filePath;
    
    public VehicleFileParser(String filePath) {
        _filePath = "myPizzaData.txt"; //File path String
    }
    
    // Kept as private so can not be accessed out side scope of the parent class. 
    public ArrayList<DeliveryVehicle> deliveryVehicleController;

    /**
     *
     * Will loop through the text file line by line
     * pass each line back through the DeliveryVehicleController Class based on its vehicle type.
     *  
    */
    public ArrayList<DeliveryVehicle> getVehiclesFromFile() throws java.io.IOException {
          
           DeliveryVehicleController controller = new DeliveryVehicleController();
            
           //reading the file and adding all lines to the list
           List<String> lines = Files.readAllLines(Paths.get(_filePath));
           String[] lineTokens;
           List<String> fileLines = Files.readAllLines(Paths.get(_filePath));

            for(String line : fileLines) {
                lineTokens = line.split(" ");
                
                //Possible to change if statement case statement instead
                // [0] = Bike   Used to check what type (never going to change)
                // [1] = RegNumber
                // [2] = EngineSize
                // [3] = DaysInService
                // [4] = MilesCovered
                // [5] = Deliverys

                if (lineTokens[0].equalsIgnoreCase("Bike")){
                    // System.out.print(lineTokens[1] + "THISSHOULD BE REG NUMBER");
                    controller.addBike( lineTokens[1] , Integer.parseInt(lineTokens[2]), Integer.parseInt(lineTokens[3] ), Double.parseDouble(lineTokens[4] ), Integer.parseInt(lineTokens[5]) );
                     // return _vehicleList;
                    // System.out.print(_vehicleList);
                }

                else if (lineTokens[0].equalsIgnoreCase("Car")){
                    controller.addCar( lineTokens[1] , Integer.parseInt(lineTokens[2]), Integer.parseInt(lineTokens[3] ), Double.parseDouble(lineTokens[4] ), Integer.parseInt(lineTokens[5]) );
                     // return _vehicleList;
                }

                else if (lineTokens[0].equalsIgnoreCase("Scooter")){
                    // _vehicleList.add(new DeliveryScooter( lineTokens[1] , Integer.parseInt(lineTokens[2]), Integer.parseInt(lineTokens[3] ), Double.parseDouble(lineTokens[4] ), Integer.parseInt(lineTokens[5]) ));
                    controller.addScooter( lineTokens[1] , Integer.parseInt(lineTokens[2]), Integer.parseInt(lineTokens[3] ), Double.parseDouble(lineTokens[4] ), Integer.parseInt(lineTokens[5]) );
                     // return _vehicleList;
                }
            } 
        
           return controller.getVehiclesList();
          
       } // End of getVehiclesFromFile Method

    /**
     *
     * Will add the current vehicleArrayList to the textFile and format it according to the toStrpass each line back through the DeliveryVehicleController Class based on its vehicle type.
     * @vehicleList - Is an array list of type DeliveryVehicle
     *
    */
    public void saveAllVehiclesToFile(ArrayList<DeliveryVehicle> vehicleList) throws java.io.IOException {

        // write object to file
        FileOutputStream fos = new FileOutputStream(_filePath); //object to hold a file, e.g. EmployeeData.txt
        PrintStream writer = new PrintStream(fos); //object to write data

        //For loop to read each employee and write them to the file
        for(DeliveryVehicle vehicle : vehicleList){
            writer.println(vehicle);
        }

        writer.close();//close the writer
        fos.close();//close the file

    }

    } // End of class
