/**
 * This is the GUI of the application and interacts with the DeliveryContollerClass to allow the user navigate the application
 * 
 * @author Michael O Meara Fearghal O Sullivan Conor Ryan
 * @version 1
 */

import java.util.*;
import java.io.Console;
import javax.swing.JOptionPane;
public class PizzaDeliveryApp{

    public  DeliveryVehicleController controller;

        // Varibles used for creating each new vehcile object
    public String registrationNumber, engineSize, daysInService, milesCovered, deliveryMade; 
    public boolean open = true;

    public PizzaDeliveryApp() {
        // _deliveryVehiclesController = new DeliveryVehicleController();
        controller = new DeliveryVehicleController();
    }
    
    /**
     * Will open up the Main Menu of the application
     * 
    */
    public void launchApp() {

        // DeliveryVehicleController controller = new DeliveryVehicleController();
        
        String strOption;
        int option=0;
        String result;
        String  _registrationNumber; 
        
        do{
            strOption = JOptionPane.showInputDialog("Pizza Delivery Application\n 1:List All vehicles \n 2: Manage Vehicles \n 3: Record Daily Delivery Information \n 4: View Annual Running Costs \n 5: Close Application");
            try{
                option = Integer.parseInt(strOption);
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Error, Invalid Option");
                option = 0;
            }
            switch(option){          
                    
                case 1: //  List all vehicles not working

     
                            
                         String listString = controller.getVehiclesList().toString();
                         
                       JOptionPane. showInputDialog(listString);
                    
                    break;
                case 2:

                // Do loop to keep the Manage Vehicle Dialogue box open until all vehicles are added.
                do {
                     createVehicleManagerForm();
                } while (open == true);
                break;
        
                case 3:
                _registrationNumber = JOptionPane. showInputDialog("Please Enter Registration Number:");
                controller.getDeliveryVehicle(_registrationNumber);


                strOption = JOptionPane. showInputDialog("Please Enter Miles covered today:");
                strOption = JOptionPane.showInputDialog("Please Enter Deliveries made today:");
               
                  break;
                
                case 4:
                JOptionPane.showMessageDialog(null, "Option 4");
                  break;
                 
                // Closes the application    
                case 5:
                    System.exit(0);
                  break;
                    
                default:   JOptionPane.showMessageDialog(null, "Option Not Valid");
                
            
                  } // END OF MAIN MENU CASE 
          } 
              while(option!=5); // DO EVERYTHING ABOVE WHILE THE OPTION DOES NOT EQUAL 5
    

  } // End of Launch App Method

    /**
     * Menu for adding new vehicles
     * Remove vehicle Option not working
    */
    private void createVehicleManagerForm(){
      try {
                String strOption;
                int option = 0;
                strOption = JOptionPane. showInputDialog("Manage Vehicles \n 1: Add New Car \n 2:Add New Bike \n 3:Add New Scooter \n 4: Remove Vehicle \n 5: Main Menu");
               
                  try{
                    option = Integer.parseInt(strOption);
  
                    switch(option){  
                            case 1: //Add New Car
                                  try{
                                      createVehicleForm(); // Calls all the commoon Dilugue boxes for creating vehicles
                                      controller.addCar( registrationNumber , Integer.parseInt(engineSize),  Integer.parseInt(daysInService) ,  Integer.parseInt(milesCovered) ,  Integer.parseInt(deliveryMade) );
                                      controller.saveAllVehicles(); // May need to put this in a different method which wil be called from a save all button
                                      JOptionPane.showMessageDialog( null, "A Car with registration number "  + registrationNumber + " has been registered.", "Vehicle Manager", 0 ); 
                                      // option = 2;
                                  }
                                  catch (Exception ex) {
                                   // Should be an error message here
                                  }
                             break;
                            case 2: // Add New Bike
                                  try{
                                      createVehicleForm(); // Calls all the commoon Dilugue boxes for creating vehicles
                                      controller.addBike( registrationNumber , Integer.parseInt(engineSize),  Integer.parseInt(daysInService) ,  Integer.parseInt(milesCovered) ,  Integer.parseInt(deliveryMade) );
                                      controller.saveAllVehicles(); // May need to put this in a different method which wil be called from a save all button
                                      JOptionPane.showMessageDialog( null, "A Bike with registration number "  + registrationNumber + " has been registered.", "Vehicle Manager", 0 ); 
                                  }
                                  catch (Exception ex) {
                                   // Should be an error message here
                                  }
                              break;
                            case 3: // Add New Scooter
                                  try{
                                      createVehicleForm(); // Calls all the commoon Dilugue boxes for creating vehicles
                                      controller.addScooter( registrationNumber , Integer.parseInt(engineSize),  Integer.parseInt(daysInService) ,  Integer.parseInt(milesCovered) ,  Integer.parseInt(deliveryMade) );
                                      controller.saveAllVehicles(); // May need to put this in a different method which wil be called from a save all button
                                      JOptionPane.showMessageDialog( null, "A Scooter with registration number "  + registrationNumber + " has been registered.", "Vehicle Manager", 0); 
                                  }
                                  catch (Exception ex) {
                                   // Should be an error message here
                                  }
                              break;
                            case 4: // Remove Vehicle
                              break;
                            case 5: //Main Menu
                                  launchApp(); // Relaunch the original Menu

                           default:   JOptionPane.showMessageDialog(null, "Option Not Valid");
                          
                         } //END OF OPTION 2 CASE STATEMENT 
                        } catch(NumberFormatException ex) { 
                          JOptionPane.showMessageDialog(null, "Error, invalid option");
                          option= 0;
                      }
                        // while(option!=5);

      }
      catch (Exception ex) {
        // Should be an error message here
      }

    }


    /**
     * Will create the basic forms needed to create a new vehicle
     * 
    */
    private void createVehicleForm() {
          try{
              registrationNumber = JOptionPane.showInputDialog("Please insert registration number: ");
              engineSize = JOptionPane.showInputDialog("Please insert the engine size: ");
              daysInService = JOptionPane.showInputDialog("Please insert the days in service: ");
              milesCovered = JOptionPane.showInputDialog("Please insert the miles covered: ");
              deliveryMade = JOptionPane.showInputDialog("Please insert the deliverys made: ");
          }
          catch (Exception ex) {
           // Should be an error message here
            }
    }


} // End of Class
