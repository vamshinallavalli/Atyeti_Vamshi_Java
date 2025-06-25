package tasks;

import java.util.LinkedList;
import java.util.Queue;

class ProducerConsumerUsingWait_Notify{
    public static void main(String[] args) {
        ProducerConsumerUsingWait_Notify p=new ProducerConsumerUsingWait_Notify();

        Thread producer=new Thread(()->{
            int value=0;

            try{
                while(true){
                    p.produce(value++);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer=new Thread(()->{

            try{
                while(true){
                    p.consumer();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        producer.start();
        consumer.start();

    }
   Queue<Integer> queue=new LinkedList<>();
    int capacity=5;

    public synchronized void produce(int value) throws InterruptedException {
        while(capacity==queue.size()) wait();
        queue.add(value);
        System.out.println("Producer: "+value);
        notifyAll();
    }

    public synchronized void consumer() throws InterruptedException {
        while (queue.isEmpty()) wait();
        int value=queue.poll();
        System.out.println("Consumer: "+value);
        notifyAll();
    }
}