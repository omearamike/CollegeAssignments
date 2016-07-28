/**
 * This code will allow the user to increase and decrease temperature between a specified range.
 * @author Michael O Meara
 * @student_ID 14439592
 * @assignment #1 Part B
 * @Date 2 Feb 2016
 * @Class Adv Application Dev 2
 */
    
public class Heater{
    
    double _temperature;
    double _min;
    double _max;
    double _increment;
    
    // Initializes the Heater Class
    public Heater(double min, double max) {
        _temperature = 15;
        _increment = 5; //default
        _min = min;
        _max = max;
    }
    
    // Sets the amount to increment the temperature
    public void setIncrement(double increment) {

        if(increment<= 0){
            System.out.println("Invalid entry must be positive value");
            return;   
        }   
        
        _increment = increment;
    }
    
    // Increments temperature higher
    public void makeWarmer(){
        
        if((_temperature + _increment)>_max){
            
            System.out.println("Keep temperature below the max: " + _max);
            return;
        }
        
        _temperature += _increment;
    }

    // Increments the temperature lower
    public void makeCooler(){
        
        if((_temperature - _increment)<_min){

            System.out.println("Keep temperature above the min: " + _min);
            return;
        }
        
        _temperature -= _increment;
    }
    
    // Returns the temperature at any point during run time
    public double getTemperature() {
        return _temperature; 
    }
    
}
