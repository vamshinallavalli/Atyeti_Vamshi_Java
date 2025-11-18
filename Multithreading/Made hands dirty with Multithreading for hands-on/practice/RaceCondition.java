import java.util.concurrent.atomic.AtomicInteger;

public class RaceCondition {
    AtomicInteger count = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException{
        RaceCondition obj=new RaceCondition();
        Thread  t1=new Thread(()->obj.run());
        Thread  t2=new Thread(()->obj.run());

        t1.start();
        t2.start();

        t1.join();
        t2.join();


    }

    public  void run(){
        for(int i=0;i<500;i++){
            //System.out.println(count);
            //count++;
            System.out.println(count.get());
            count.incrementAndGet();
        }
    }
}