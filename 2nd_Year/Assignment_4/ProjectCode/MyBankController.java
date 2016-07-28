/**
 * This Class MyBankController will be used to control the BankAccount Class.
 * @author Michael O Meara
 * @student_ID 14439592
 * @assignment #4
 * @Date 23 Feb 2016
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
            //nt account = itemToDelete.getAccountNumber(); 
            if (itemToDelete.getAccountNumber() == accountNumber){
                obj.remove();
                System.out.println("Deleted address " + accountNumber + ".");
                return;
            }

        }   
        System.out.println(accountNumber + ": Not a valid account number.");

    } //end of while

    // Creates the account object based on accountNumber
    private BankAccount getAccount(int accountNumber){

        for(BankAccount account: list){      
            if (account.getAccountNumber() == accountNumber){
                return account;
            }
        }
        System.out.println("There is no record can be found for this Account Number: " + accountNumber + "\nCan not perform task.");
        return null;
    }

    //Makes withdrawel from account.
    public void makeWithdrawal(int accountNumber, double amount){

        BankAccount account = getAccount(accountNumber);

        if (account != null){
            account.makeWithdrawal(amount);
        }
    }

    //makes lodgement to account
    public void makeLodgement(int accountNumber, double amount){

        BankAccount account = getAccount(accountNumber);

        if (account != null){
            account.makeLodgement(amount);
        }
    }

    // Closes account
    public void closeAccount(int accountNumber){

        BankAccount account = getAccount(accountNumber);

        if (account != null){
            account.closeAccount();
        }
    }

    // Displays account details
    public void displayAccount(int accountNumber){

        BankAccount account = getAccount(accountNumber);

        if (account != null){
            System.out.println(account.displayAccount());
        }
    }

}
