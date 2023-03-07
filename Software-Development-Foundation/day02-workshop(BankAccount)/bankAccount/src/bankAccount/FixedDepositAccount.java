package bankAccount;

public class FixedDepositAccount extends BankAccount{
    float interest = 3.f;
    int durInMonths = 6;
    Boolean isSetInterest = false;
    Boolean isSetDuration = false;

    //explicit super constructor
    public FixedDepositAccount(String name, float bal){
        super(name, bal);
    }
    public FixedDepositAccount(String name, float bal, float interest){
        super(name, bal);
        setInterest(interest);

        //reset booleans
        setIsSetInterest(false);
    }
    public FixedDepositAccount(String name, float bal, float interest, int duration){
        super(name, bal);
        setDurInMonths(duration);
        setInterest(interest);

        //reset booleans 
        setIsSetInterest(false);
        setIsSetDuration(false);
    }

    public Boolean getIsSetInterest() {return isSetInterest;}
    public void setIsSetInterest(Boolean isSetInterest) {this.isSetInterest = isSetInterest;}

    public Boolean getIsSetDuration() {return isSetDuration;}
    public void setIsSetDuration(Boolean isSetDuration) {this.isSetDuration = isSetDuration;}

    public float getInterest() {return interest;}
    public void setInterest(float interest) {
        if(!isSetInterest){
            this.interest = interest;
            setIsSetInterest(true);
            System.out.printf("sucessfully set interest rate to %.1f%%\n",this.interest);
        }
        else{System.err.println("Cannot adjust interest again. Error: " + new IllegalArgumentException() + "\n");}
    }

    public int getDurInMonths() {return durInMonths;}

    public void setDurInMonths(int durInMonths) {
        if(!isSetDuration){
            this.durInMonths = durInMonths;
            setIsSetDuration(true);
            System.out.printf("sucessfully set duration to %d\n",this.durInMonths);
        }
        else{System.err.println("Cannot adjust duration again. Error: " + new IllegalArgumentException() + "\n");}
        
    }

    @Override
    public void deposit(float amt){}

    @Override
    public void withdraw(float amt){}

    public float getBalance()
    {
        float earnedInterest = getInterest() * getDurInMonths();
        float bal = earnedInterest + super.getAccountBal();
        return bal;
    }

}