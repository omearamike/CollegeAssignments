/**
 * Inherited class of DeliveryVehicle
 * 
 * @author Michael O Meara Fearghal O Sullivan Conor Ryan
 * @version 1
 */

public class DeliveryBike extends DeliveryVehicle 
{

    private double _noEmmissionsGrant; //added the emissions grant

    public DeliveryBike(String registrationNumber, int engineSize, int daysInService,
    double milesCovered, int deliveriesMade) {
      
        super( registrationNumber, engineSize, daysInService, milesCovered, deliveriesMade);
        setVehicleType("Bike");
        setEngineSize(0);
        setFuelCostPerMile(0);
        setAnnualMaintenenceCost(200);
        _noEmmissionsGrant = 100;  //added the emissions grant

    }

    //public abstract double calculateRunningCost();
    @Override
    public double calculateRunningCost() {
        //double fuelCost = getFuelCostPerMile() *  getMilesCovered();
        double totalRunningCosts = getAnnualMaintenenceCost() - _noEmmissionsGrant;
        return totalRunningCosts;
    }
}
