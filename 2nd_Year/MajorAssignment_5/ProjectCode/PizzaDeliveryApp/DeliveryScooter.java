
/**
 * Inherited class of DeliveryVehicle
 * 
 * @author Michael O Meara Fearghal O Sullivan Conor Ryan
 * @version 1
 */

public class DeliveryScooter extends DeliveryVehicle 
{
    
    public DeliveryScooter(String registrationNumber, int engineSize, int daysInService,
    double milesCovered, int deliveriesMade) {
      
        
        super( registrationNumber, engineSize, daysInService, milesCovered, deliveriesMade);
        setVehicleType("Scooter");
        setEngineSize(50);
        setFuelCostPerMile(0.08);
        setAnnualMaintenenceCost(1000);
        
    }

    //public abstract double calculateRunningCost();
    @Override
    public double calculateRunningCost() {
        double fuelCost = getFuelCostPerMile() *  getMilesCovered();
        double totalRunningCosts = fuelCost + getAnnualMaintenenceCost();
        return totalRunningCosts;
    }
}
