public class WhyLock {
    public static void main(String[] args) {

        BankAccount bank=new BankAccount();

        Runnable task=new Runnable() {
            @Override
            public void run() {
                bank.withdraw(500);
            }
        };

        Thread t1=new Thread(task,"Vamshi");
        Thread t2=new Thread(task,"Krishna");

        t1.start();
        t2.start();
    }
}
