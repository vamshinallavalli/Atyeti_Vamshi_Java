package ProducerConsmerProblem;

class Main{
    public static void main(String[] args) {
        SharedBuffer buffer=new SharedBuffer();

        new Producer(buffer).start();
        new Consumer(buffer).start();
    }
}