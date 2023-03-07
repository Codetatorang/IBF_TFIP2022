package bankAccount;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class BankAccount{
    private String name = "";
    private String accountNum = "";
    private Float accountBal = 0.f;
    private List<String> transactions = new LinkedList<String>();
    private boolean closed = false;
    private String accountCreatedDate = "";
    private String accountClosedDate = "";

    //constructor overload
    public BankAccount(String name){
        this.name = name;
        setAccountBal(0.f);
        //format datetime to dd/mm/yyyy format
        LocalDate date = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
        this.accountCreatedDate = date.format(dtf).toString();
    }
    public BankAccount(String name, float bal){
        this.name = name;
        setAccountBal(bal);

        //format datetime to dd/mm/yyyy format
        LocalDate date = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
        this.accountCreatedDate = date.format(dtf).toString();
    }

    //members
    public String getName() {return name;}
    public String getAccountNum() {return accountNum;}
    
    public Float getAccountBal() {return accountBal;}
    public void setAccountBal(Float accountBal) {this.accountBal = accountBal;}

    public List<String> getTransactions() {return transactions;}
    public void setTransactions(List<String> transactions) {this.transactions = transactions;}

    public boolean isClosed() {return closed;}
    public void setClosed(boolean closed) {this.closed = closed;}

    public String getAccountCreatedDate() {return accountCreatedDate;}
    public void setAccountCreatedDate(String accountCreatedDate) {this.accountCreatedDate = accountCreatedDate;}

    public String getAccountClosedDate() {return accountClosedDate;}
    public void setAccountClosedDate(String accountClosedDate) {this.accountClosedDate = accountClosedDate;}

    //methods
    //deposit
    public void deposit(float amt){
        try{
            if(amt <= 0 || this.isClosed()){
                throw new IllegalArgumentException();
            }
            accountBal += amt;
            //convert datetime to local format
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy h.m.sa");
            String formattedDateTime = dateTime.format(dtf).toString();
            //store this transaction into transactions list
            String message  = String.format("Sucessfully deposited $%.2f at %s\n",amt,formattedDateTime);
            transactions.add(message);
            System.out.printf(message);

        }catch(IllegalArgumentException ex){ 
            if (this.isClosed()){System.err.println("This account has been closed.");}
            else if (amt <= 0){System.err.printf("You cannot deposit $: %.2f. Please try again.\n", amt);}
            else{System.err.println("Encountered exception " + ex);}
            }
    }
    //withdraw
    public void withdraw(float amt) {
        try {
            if (accountBal < amt || isClosed()) {
                throw new IllegalArgumentException();
            }
            accountBal -= amt;

            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy h.m.sa");
            String formattedDateTime = dateTime.format(dtf).toString();
            //store this transaction into transactions list
            String message  = String.format("Sucessfully withdrawed $%.2f at %s\n",amt,formattedDateTime);
            transactions.add(message);
            System.out.printf(message);

        } catch (IllegalArgumentException ex) {
            if (isClosed()) {
                System.err.println("This account has been closed");}
            else if(accountBal < amt){
                System.err.printf("Cannot withdraw %.2f, You are left with only %.2f in your account.\n", amt,accountBal);}
            else{System.err.println("Encountered exeception: " + ex);}
        }
    }
}