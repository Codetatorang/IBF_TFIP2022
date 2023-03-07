package bankAccount;

public class Main {
    public static void main(String[]args){
        //init
        BankAccount vincAccount = new BankAccount("Vincent", 1100);
        FixedDepositAccount vincFixedD = new FixedDepositAccount("Vincent Ang", 3045, 3.0f, 2);

        //test case for BankAccount object
        vincAccount.deposit(1.f);
        System.out.printf("Remaining balance: %f\n", vincAccount.getAccountBal());
        //get error
        vincAccount.deposit(-1.f); 
        System.out.printf("Remaining balance: %f\n", vincAccount.getAccountBal());


        //test case for FixedDepositAccount object
        System.out.printf("current interest rate: %f\n", vincFixedD.getInterest());
        vincFixedD.setInterest(7);
        System.out.printf("new interest rate after fixed interest 7%%: %f\n", vincFixedD.getInterest());
        vincFixedD.setInterest(11);
        System.out.printf("new interest rate: %f\n", vincFixedD.getInterest());

    }
}