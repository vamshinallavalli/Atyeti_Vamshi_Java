public class SynchronizedBlock {
    int count=0;
    public static void main(String[] args) throws InterruptedException{
        SynchronizedBlock obj=new SynchronizedBlock();
        Thread  t1=new Thread(()->obj.run());
        Thread  t2=new Thread(()->obj.run());

        t1.start();
        t2.start();

        t1.join();
        t2.join();


    }

    public  void run(){

        synchronized(this){
            for(int i=1;i<=5;i++){
                System.out.println(count);
                count++;
            }
        }
    }
}
