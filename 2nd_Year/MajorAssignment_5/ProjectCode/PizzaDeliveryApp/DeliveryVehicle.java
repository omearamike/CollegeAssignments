
/**
 * Abstract class DeliveryVehicle - Contains Getters and Setters to create new vehicles
 * 
 * @author Michael O Meara Fearghal O Sullivan Conor Ryan
 * @version 1
 */
public abstract class DeliveryVehicle
{
    private String _registrationNumber;
    private String _vehicleType;
    private int _engineSize;
    private int _daysInService;
    private double _milesCovered;
    private int _deliveriesMade;
    private double _fuelCostPerMile;
    private double _annualMaintenenceCost;
    
    public DeliveryVehicle(String registrationNumber, int engineSize, int daysInService, 
    double milesCovered, int deliverysMade){
        _registrationNumber = registrationNumber;
        _engineSize = engineSize;
        _daysInService = daysInService;
        _milesCovered = milesCovered;
        _deliveriesMade = deliverysMade;
    }

    //RegistrationNumber
    // Return methods of class
    public String getRegistrationNumber(){ 
        return _registrationNumber;   
    }

    // Set new value
    public void setRegistrationNumber(String registrationNumber){ 
        _registrationNumber = registrationNumber;   
    }

    //VehicleType
    // Return methods of class
    public String getVehicleType(){ 
        return _vehicleType;   
    }

    // Set new value
    public void setVehicleType(String vehicleType){ 
        _vehicleType = vehicleType;   
    }

    //EngineSize
    // Return methods of class
    public int getEngineSize(){ 
        return _engineSize;   
    }

    // Set new value
    public void setEngineSize(int engineSize){ 
        _engineSize = engineSize;   
    }


    //DaysInService
    // Return methods of class
    public int getDaysInService(){ 
        return _daysInService;   
    }

    // Increment new value
    public void incrementDaysInService(){ 
        _daysInService++;
    }


    //MilesCovered
    // Return methods of class
    public double getMilesCovered(){ 
        return _milesCovered;   
    }



    // Add new value
    public void addMilesCovered(double milesCovered){ 
        _milesCovered += milesCovered;   
    }


    //DeliveriesMade
    // Return methods of class
    public int getDeliveriesMade(){ 
        return _deliveriesMade;   
    }

    // Set new value
    public void addDeliveriesMade(int deliverysMade){ 
        _deliveriesMade += deliverysMade;   
    }


    //FuelCostPerMile
    // Return methods of class
    public double getFuelCostPerMile(){ 
        return _fuelCostPerMile;   
    }

    // Set new value
    public void setFuelCostPerMile(double fuelCostPerMile){ 
        _fuelCostPerMile = fuelCostPerMile;   
    }

    //AnnualMaintenceCost
    // Return methods of class
    public double getAnnualMaintenenceCost(){ 
        return _annualMaintenenceCost;   
    }

    // Set new value
    public void setAnnualMaintenenceCost(double annualMaintenenceCost){ 
        _annualMaintenenceCost = annualMaintenenceCost;   
    }

    public abstract double calculateRunningCost(); //All children of this class will have to run this method!!

    @Override
    public String toString(){
    	return String.format("%s %s %s %s %.2f %s",
            getVehicleType(),
            getRegistrationNumber(),
            getEngineSize(),
            getDaysInService(),
            getMilesCovered(),
            getDeliveriesMade());
    }

    
}
