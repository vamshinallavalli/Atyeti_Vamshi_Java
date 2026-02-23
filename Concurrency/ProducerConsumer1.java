
class Shared {
    int data;
    boolean available = false;

    synchronized void produce(int value) throws InterruptedException {
        while (available)
            wait();

        data = value;
        available = true;
        System.out.println("Produced: " + data);
        notify();
    }

    synchronized void consume() throws InterruptedException {
        while (!available)
            wait();

        System.out.println("Consumed: " + data);
        available = false;
        notify();
    }
}

class Producer implements Runnable {
    Shared shared;

    Producer(Shared shared) {
        this.shared = shared;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                shared.produce(i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    Shared shared;

    Consumer(Shared shared) {
        this.shared = shared;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                shared.consume();
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ProducerConsumer1 {
    public static void main(String[] args) {
        Shared shared = new Shared();

        Thread producer = new Thread(new Producer(shared));
        Thread consumer = new Thread(new Consumer(shared));

        producer.start();
        consumer.start();
    }
}
