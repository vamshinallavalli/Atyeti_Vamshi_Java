/*
Java Scenario 11:  Bank Account Withdrawal
Multiple threads withdraw from the same account. How do you make sure to avoid race
conditions. What techniques you would use?
 */
public class Scenario11 {

    static double balance=1500;
    public static void main(String[] args) throws InterruptedException {
        Scenario11 scenario=new Scenario11();

        Thread t1=new Thread(()->scenario.withdraw(1000));
        Thread t2=new Thread(()->scenario.withdraw(500));

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Balance in the account is: "+balance);
    }

    private void withdraw(int i) {
        if(balance>i){
            balance=balance-i;
            System.out.println("Withdraw successfully of amount:"+i);
        }else{
            System.out.println("Insufficient Balance!");
        }
    }
}
