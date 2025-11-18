public class SynchronizedBankAccount {
    static double balance=0;
    public static void main(String[] args) throws InterruptedException {
        SynchronizedBankAccount obj=new SynchronizedBankAccount();
        Thread t1=new Thread(()-> {
            try {
                obj.withdraw(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2=new Thread(()->obj.deposit(1000));

        System.out.println("Account Balance before transactions : "+balance);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Account Balance after transactions: "+balance);
    }

    public synchronized void withdraw(double amount) throws InterruptedException {
        while(balance<amount) {
            System.out.println("Insufficient Balance");
            wait();
        }

            balance=balance-amount;
            System.out.println("Withdraw successful of amount :" + amount);

    }

    public synchronized void deposit(double amount){
        System.out.println("Deposit Successful of amount : "+amount);
        balance=balance+amount;
        System.out.println("Balance after deposit: "+balance);
        notifyAll();


    }
}
