public class RunnableInterfaceSquares {
    public static void main(String[] args) {
        Thread t=new Thread(new Runnable(){
            public void run(){
                for(int i=1;i<=10;i++){
                    System.out.println(i+" Square is: "+i*i);
                }
            }
        } );

        t.start();
    }
}
