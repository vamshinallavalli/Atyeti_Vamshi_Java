package basic;

public class Rough{
    public static void main(String[] args) {
        Practice practice=new Practice();
        Thread t=new Thread(practice);
        t.start();
    }
}

class Practice implements Runnable{

    @Override
    public void run(){

        int sum=0;
        for(int i=0;i<100;i++){
            sum+=i;
        }
        System.out.println("Sum is: "+sum);
    }
}
