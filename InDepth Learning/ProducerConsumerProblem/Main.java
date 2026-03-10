import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Main{
    public static void main(String[] args) {

        BlockingQueue<Integer> queue=new ArrayBlockingQueue<>(3);

        Thread producer=new Thread(new Producer(queue));
        Thread consumer=new Thread(new Consumer(queue));

        producer.start();
        consumer.start();
    }
}