/**
 * Inherited class of DeliveryVehicle
 * 
 * @author Michael O Meara Fearghal O Sullivan Conor Ryan
 * @version 1
 */

public class DeliveryCar extends DeliveryVehicle 
{

    private double _yearlyTax; //added the yearly tax 


    public DeliveryCar(String registrationNumber, int engineSize, int daysInService,
    double milesCovered, int deliveriesMade) {

        super( registrationNumber, engineSize, daysInService, milesCovered, deliveriesMade);
        setVehicleType("Car");
        setTax(engineSize);
        setFuelCost(engineSize);
        setAnnualMaintenenceCost(2000);
    }

    //Setting the yearly Tax band for each vehicle.
    private void setTax(int engineSize)   {

            switch (engineSize) {
            case 1000: _yearlyTax = 150;
                     break;
            case 1200: _yearlyTax = 250;
                     break;
            case 1300: _yearlyTax = 350;
                     break;
            case 1600: _yearlyTax = 450;
                     break;
            case 2000: _yearlyTax = 500;
                     break;
            default: _yearlyTax = 0; //Need to put in error handling here
                     break;
        }

    }

    //Setting the FuelCost / mile for each car.
    private void setFuelCost(int engineSize){

            switch (engineSize) {
            case 1000: setFuelCostPerMile(0.10);
                     break;
            case 1200: setFuelCostPerMile(0.115);
                     break;
            case 1300: setFuelCostPerMile(0.135);
                     break;
            case 1600: setFuelCostPerMile(0.14);
                     break;
            case 2000: setFuelCostPerMile(0.16);
                     break;
            default: setFuelCostPerMile(0); //Need to put in error handling here
                     break;
        }
    }

    //public abstract double calculateRunningCost();
    @Override
    public double calculateRunningCost() {
        double fuelCost = getFuelCostPerMile() *  getMilesCovered();
        double totalRunningCosts = fuelCost + getAnnualMaintenenceCost() + _yearlyTax;
        return totalRunningCosts;
    }
}

