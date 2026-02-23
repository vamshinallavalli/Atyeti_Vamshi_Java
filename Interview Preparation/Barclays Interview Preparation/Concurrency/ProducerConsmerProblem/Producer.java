package ProducerConsmerProblem;

class Producer extends Thread{
    private SharedBuffer buffer;

    public Producer(SharedBuffer buffer){
        this.buffer=buffer;
    }

    public void run(){
        for(int i=1;i<=5;i++){
            try {
                buffer.produce(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}