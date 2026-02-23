package ProducerConsmerProblem;

class Consumer extends Thread{
    private SharedBuffer buffer;


    public Consumer(SharedBuffer buffer) {
        this.buffer=buffer;
    }

    public void run(){
        for(int i=1;i<=5;i++){
            try {
                buffer.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}