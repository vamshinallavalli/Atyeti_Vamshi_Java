public class TwoThreadsPingPong {
    public static void main(String[] args) {
        Pingpong pp=new Pingpong();

        Thread ping=new Thread(()->pp.ping());
        Thread pong=new Thread(()->pp.pong());

        ping.start();
        pong.start();
    }
}

class Pingpong{

    private boolean pingTurn = true;
    synchronized void ping(){
        for(int i=0;i<5;i++){
            while(!pingTurn){
                try{
                    wait();
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("ping");
            pingTurn =false;
            notify();
        }
    }



    synchronized void pong(){
        for(int i=0;i<5;i++){
            while(pingTurn){
                try{
                    wait();
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("pong");
            pingTurn=true;
            notify();
        }
    }
}
