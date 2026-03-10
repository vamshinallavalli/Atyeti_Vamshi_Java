import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue){
        this.queue=queue;
    }
    @Override
    public void run(){
        try{
            for(int i=1;i<=5;i++){
                System.out.println("Produced: "+i);
                queue.put(i);
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
