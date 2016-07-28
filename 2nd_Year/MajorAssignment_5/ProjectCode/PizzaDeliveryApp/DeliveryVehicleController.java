/**
 * Is the main controller class of the application and interacts with all other classes 
 * Unable to get all of this class working due to issue with the _vehicleList varible not working properly when retreiving text from file
 * 
 * @author Michael O Meara Fearghal O Sullivan Conor Ryan
 * @version 1
 */

import java.util.*;
import java.io.Console;
//Constructer Class
public class DeliveryVehicleController{

    // Kept as private so can not be accessed out side scope of the parent class.
    public ArrayList<DeliveryVehicle> _vehicleList = new ArrayList<DeliveryVehicle>(); //private vehicleFileParser _vehicleFileParser;
    public VehicleFileParser _vehicleFileParser; //variable to enable reading and saving of file

    public static final String DATA_FILE = "myPizzaData.txt";

    public DeliveryVehicleController(){
        _vehicleFileParser = new VehicleFileParser(DATA_FILE); //may need to change the file name.
    }


    /**
     * Will interact with the VehicleFileParser Class 
     * Will call the getVehiclesFromFile method to retreive all vehcile objects from the text file
    */
    public ArrayList<DeliveryVehicle> getAllSavedVehicles() throws java.io.IOException {
        return _vehicleFileParser.getVehiclesFromFile();
    }

    /**
     * Will return the current _vehcileList
     * 
    */
    public ArrayList<DeliveryVehicle> getVehiclesList(){
        return _vehicleList;
    }

    /**
     * Will interact with the VehicleFileParser Class 
     * Will call the saveAllVehiclesToFile method to save the the _vehicleList to the text File
     * 
    */
    public void saveAllVehicles() throws java.io.IOException {
        _vehicleFileParser.saveAllVehiclesToFile(_vehicleList);
     }

    /**
     * Will add the new vehicle to the _vehicleList Array List
     * 
     *   @newVehicle Will take in a vehicle 
    */
    public void addDeliveryVehicle(DeliveryVehicle newVehicle){
        //Need to add the newly created vehicle to the _vehicleList
        _vehicleList.add(newVehicle);
    }

    /**
     * This method will interact with the DeliveryCar Class to create a new Car Object
     * It will then add the vehicle to the _vehicleList ArrayList
     * 
     *   @param all necessary params to create a new Car Object
    */
    public void addCar(String registrationNumber, int engineSize, int daysInService, double milesCovered, int deliveriesMade) {
        DeliveryCar newCar = new DeliveryCar( registrationNumber, engineSize, daysInService, milesCovered, deliveriesMade);
        addDeliveryVehicle(newCar);    
    }

    /**
     * This method will interact with the DeliveryBike Class to create a new Bike Object
     * It will then add the vehicle to the _vehicleList ArrayList
     * 
     *   @param all necessary params to create a new Bike Object
    */
    public void addBike(String registrationNumber, int engineSize, int daysInService, double milesCovered, int deliveriesMade) {
        DeliveryBike newBike = new DeliveryBike( registrationNumber, engineSize, daysInService, milesCovered, deliveriesMade);
        addDeliveryVehicle(newBike);  
    }

    /**
     * This method will interact with the DeliveryScooter Class to create a new Scooter
     * It will then add the vehicle to the _vehicleList ArrayList
     * 
     *   @param all necessary params to create a new Scooter Object
    */
    public void addScooter(String registrationNumber, int engineSize, int daysInService, double milesCovered, int deliveriesMade) {
        DeliveryScooter newScooter = new DeliveryScooter( registrationNumber, engineSize, daysInService, milesCovered, deliveriesMade);
        addDeliveryVehicle(newScooter);  
        // System.out.print(_vehicleList);  // This is a test to check if the _vehicleList Array will print out at this point in the code
    }
    
    /**
     * Test to check the contents of the _vehicleList ArrayList at any point 
     * 
    */
    public void testPrintArrayList() {
        System.out.print(_vehicleList); 
    }

    // public DeliveryVehicle getVehicleList 

    /**
     *  Will Return a vehicle object based on its registration number
     *   @registrationNumber Reg Number to search for
    */
    public DeliveryVehicle getDeliveryVehicle(String registrationNumber){

        for (DeliveryVehicle vehicle : _vehicleList) {
            if (vehicle.getRegistrationNumber().equalsIgnoreCase(registrationNumber)){
                 return vehicle;
            }
        }
        return null;
    }

    /**
     *   Will update a vehicle with the milescovered and deliverys Made
     *   @vehicleToUpdate will require the vehicle object to be updated to be passed in
    */
    public String updateDeliveryVehicle(DeliveryVehicle vehicleToUpdate){
        
        Console console = System.console();
        String milesCovered = console.readLine("Input the miles covered today: ");   
        String deliverysMade = console.readLine("Input the deliverys made today: ");  
        // System.out.print("")
        

        vehicleToUpdate.addMilesCovered(Double.parseDouble(milesCovered));
        vehicleToUpdate.addDeliveriesMade(Integer.parseInt(deliverysMade));
        return "Vehicle has been updated";
    }

    public String deleteDeliveryVehicle(String registrationNumber){
        //Need to add a loop here to delete the vehicle based on a search.
        return registrationNumber;
    }

}
