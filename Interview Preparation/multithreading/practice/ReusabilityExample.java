package practice;

public class ReusabilityExample {
    public static void main(String[] args) throws InterruptedException {

        Thread t1=new Thread(()->{
            System.out.println("Hello Using Thread....");
        });

        Runnable runnable=()->{
            System.out.println("Hello Using Runnable....");
        };

        Thread t2=new Thread(runnable);

        t1.start();
        t2.start();

        t1.join();
        t2.join();


        new Thread(runnable).start();

    }
}
