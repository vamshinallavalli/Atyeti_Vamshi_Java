package ProducerConsmerProblem;

class SharedBuffer{

    private boolean isAvailable=false;
    private int data;

    public synchronized void produce(int i) throws InterruptedException {
        while (isAvailable){
            wait();
        }
        data=i;
        System.out.println("Produce: "+data);
        isAvailable=true;
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while (!isAvailable){
            wait();
        }
        System.out.println("Consumed: "+data);
        isAvailable=false;
        notify();
    }
}