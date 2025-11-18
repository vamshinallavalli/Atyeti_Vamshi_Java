public class Print1to10 {
    int countFrom=1;
    int limit=10;
    public static void main(String[] args) {
        Print1to10 obj=new Print1to10();

        Thread t1=new Thread(()->{
            try {
                obj.print();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2=new Thread(()->{
            try {
                obj.print();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        t1.start();
        t2.start();
    }

    public synchronized void print() throws InterruptedException {
      while(countFrom<=limit){
          System.out.println(Thread.currentThread().getName()+" -> "+countFrom);
          countFrom++;
          notifyAll();
          wait();
      }
      notifyAll();
    }
}
