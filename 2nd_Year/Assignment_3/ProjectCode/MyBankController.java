/**
 * This Class MyBankController will be used to control the BankAccount Class.
 * @author Michael O Meara
 * @student_ID 14439592
 * @assignment #3
 * @Date 17 Feb 2016
 * @Class Adv Application Dev 2
 */

import java.util.ArrayList;
import java.util.Iterator;

public class MyBankController{

    ArrayList <BankAccount> list = new ArrayList<BankAccount>();
    BankAccount _newBankAccount; 
    
    public MyBankController() {
    }
    
    //created object of the BankAccount Class
    public void createAccount(String name, int accountNumber){
        
        list.add(new BankAccount(name, accountNumber));
        
    }

   //Displaying details of bank account
    public void printAccountDetails(){ 

       System.out.println(_newBankAccount.displayAccount());

    }

    //Lists all Accounts in the Array
    public void listAllAccounts(){

        for (BankAccount obj : list) {

             System.out.println(obj.displayAccount());
    } 
  }


    //Update the cust name.
    public void updateCustomerName(String name, int accountNumber){
        for (BankAccount obj : list){
            if(obj.getAccountNumber() == accountNumber){
                obj.setName(name);
                System.out.println("Name for Account Number: " + obj.getAccountNumber() + " has been changed to " + name);
                return;
            }
        }
            System.out.println(accountNumber + ": Not a valid account number.");
    }

    //Remove account from the Application.
    public void removeAccount (int accountNumber){

       Iterator<BankAccount> obj = list.iterator(); //get the iterator for the list
       while(obj.hasNext()){
            BankAccount itemToDelete = obj.next(); //bring back the current object
            int account = itemToDelete.getAccountNumber(); 
            
            if(account == (accountNumber)){
                obj.remove();
                System.out.println("Deleted address " + accountNumber + ".");
                return;
            }
            
             System.out.println(accountNumber + ": Not a valid account number.");

       } //end of while
    }
}
