public class OneThreadFinishesBeforeAnotherStarts {
    public static void main(String[] args) throws InterruptedException{
        Pingpong1 pp=new Pingpong1();

        Thread ping=new Thread(()->pp.ping());
        Thread pong=new Thread(()->pp.pong());

        ping.start();
        ping.join();

        pong.start();
    }
}

class Pingpong1{

    private boolean pingTurn = true;
    synchronized void ping(){
        for(int i=0;i<5;i++){
            // while(!pingTurn){
            //     try{
            //         wait();
            //     }
            //     catch(InterruptedException e){
            //         e.printStackTrace();
            //     }
            // }
            System.out.println("ping");
            // pingTurn =false;
            // notify();
        }
    }



    synchronized void pong(){
        for(int i=0;i<5;i++){
            // while(pingTurn){
            //     try{
            //         wait();
            //     }
            //     catch(InterruptedException e){
            //         e.printStackTrace();
            //     }
            // }
            System.out.println("pong");
            // pingTurn=true;
            // notify();
        }
    }
}