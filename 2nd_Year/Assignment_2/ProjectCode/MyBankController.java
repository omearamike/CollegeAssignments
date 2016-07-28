/**
 * This Class MyBankController will be used to control the BankAccount Class.
 * @author Michael O Meara
 * @student_ID 14439592
 * @assignment #2 Part B
 * @Date 9 Feb 2016
 * @Class Adv Application Dev 2
 */
    

public class MyBankController{
    BankAccount _newBankAccount; 
    
    public MyBankController() {

    }
    
    //created object of the BankAccount Class
    public void createAccount(String name, int accountNumber){
        _newBankAccount = new BankAccount(name, accountNumber);  
    }

   //Displaying details of bank account
    public void printAccountDetails(){
        
        System.out.println(_newBankAccount.displayAccount());
        
    }
}
