class ProducerConsumer{

    int item;
    boolean produce=false;

    public static void main(String[] args) {

        ProducerConsumer obj=new ProducerConsumer();
        Thread produce=new Thread(()->{
            for(int i=0;i<5;i++){
                try {
                    obj.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consume=new Thread(()->{
            for(int i=0;i<5;i++){
                try {
                    obj.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        produce.start();
        consume.start();


    }

    public synchronized void produce() throws InterruptedException {
        while(produce){
            wait();
        }
        item= (int) (Math.random() * 100);
        System.out.println("Producer Produced : "+item);
        produce=true;
        notifyAll();
    }

    public synchronized void consume() throws InterruptedException{
        while(!produce){
            wait();
        }

        System.out.println("Consumer consumed : "+item);
        produce=false;
        notifyAll();
    }
}