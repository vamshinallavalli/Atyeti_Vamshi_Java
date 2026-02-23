import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PracticeLocks {
    public static void main(String[] args) {
        Demo obj=new Demo();

        Runnable task=new Runnable() {
            @Override
            public void run() {
                obj.methodA();
            }
        };

        Thread t1=new Thread(task,"Thread - 1");
        Thread t2=new Thread(task,"Thread - 2");

        t1.start();
        t2.start();
    }
}

class Demo{
   private final Lock lock=new ReentrantLock();

   public void methodA(){
       lock.lock();try {
           System.out.println(Thread.currentThread().getName() + "  Acquired Lock in Method - A");
           methodB();
       }finally {
           lock.unlock();
       }
    }


    public void methodB(){
       lock.lock();

       try{
           System.out.println(Thread.currentThread().getName() + "  Acquired Lock in Method - B");
       }finally {
           lock.unlock();
       }
    }
}


