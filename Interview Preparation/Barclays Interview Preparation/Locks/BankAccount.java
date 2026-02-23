import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private double balance = 1000;
    private final Lock lock=new ReentrantLock();

    public void withdraw(int amount) {

        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                if(balance>=amount){


                    try {
                        System.out.println(Thread.currentThread().getName()
                                + " attempting to withdraw " + amount);
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName()
                                + " withdrawal successful");
                    }catch (Exception e){

                    }finally {
                        lock.unlock();
                    }

                }else{
                    System.out.println("Insufficient Balance");
                }

            }
            else {
                System.out.println("Couldn't Acquire the lock, will try later");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


//
//        System.out.println(Thread.currentThread().getName()
//                + " attempting to withdraw " + amount);
//
//        if (balance >= amount) {
//
//            System.out.println(Thread.currentThread().getName()
//                    + " proceeding with withdrawal");
//
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//
//            balance -= amount;
//
//            System.out.println(Thread.currentThread().getName()
//                    + " completed withdrawal. Remaining balance: " + balance);
//
//        } else {
//            System.out.println(Thread.currentThread().getName()
//                    + " insufficient balance");
//        }
    }
}
