/**
 * This Class will have all the methods to create a new bank account.
 * @author Michael O Meara
 * @student_ID 14439592
 * @assignment #3 Part A
 * @Date 17 Feb 2016
 * @Class Adv Application Dev 2
 */
    

public class BankAccount{
   
    
    private String _name;
    private int _accountNumber;
    private double _currentBalance;
    private boolean _accountStatus;
    
    // Initializes the BankAccount Class
    public BankAccount(String name, int accountNumber) {
        _name = name;
        _accountNumber = accountNumber;
        _currentBalance = 0;
        _accountStatus = true;
    }
    
    public void makeLodgement(double amount){
        
        if (amount <= 0) {
            
            System.out.println("Amount to be lodged must be greater than 0.");
            return;
        }
        if (_accountStatus = false) {
            System.out.println("There is no active account associated with this account number.");
            return;
        }

        _currentBalance += amount;
    }

    // put the check for valid account status last as this is least likely to occur
    public void makeWithdrawal(double amount){
        
        if (amount > _currentBalance) {
            System.out.println("Insufficient Funds.");
            return;
        }
        if (amount <= 0) {
            
            System.out.println("Amount to be withdrawen must be greater than 0.");
            return;
        }
        if (_accountStatus = false) {
            System.out.println("There is no active account associated with this account number.");
            return;
        }
        
        _currentBalance -= amount;

    }

    public void closeAccount(){
        makeWithdrawal(_currentBalance); //withdraw all funds.
        _accountStatus = false; //put at end so as funds can be withdrawin before account is closed.

    }


    
    public String displayAccount(){
        return _name + ", A/C " + _accountNumber + ", Balance = €" + _currentBalance;
    }
    
    // Return methods of class
    public String getName(){ 
        return _name;   
    }

    public int getAccountNumber(){
        return _accountNumber;
    }

    public double getCurrentBalance(){
        return _currentBalance;
    }

    public boolean getAccountStatus(){
        return _accountStatus;
    }  

    public void setName(String name) {
        this._name = name;
    }
    
}
