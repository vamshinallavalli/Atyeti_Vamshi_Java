public class ThreadSafeCounter {
    int count=0;
    public static void main(String[] args) throws InterruptedException {

        ThreadSafeCounter obj=new ThreadSafeCounter();
        Thread t1=new Thread(()->obj.increment());
        Thread t2=new Thread(()->obj.increment());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }

    public synchronized void increment(){
        for(int i=0;i<100;i++){
            count++;
            System.out.println(count);
        }
    }
}
