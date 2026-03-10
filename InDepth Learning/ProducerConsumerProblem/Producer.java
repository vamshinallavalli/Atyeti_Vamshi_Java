import com.sun.security.jgss.GSSUtil;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue){
        this.queue=queue;
    }
    @Override
    public void run(){
        try{
            for(int i=1;i<=5;i++){
                Integer value=queue.take();
                System.out.println("Consumed: "+value);
                Thread.sleep(800);
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
