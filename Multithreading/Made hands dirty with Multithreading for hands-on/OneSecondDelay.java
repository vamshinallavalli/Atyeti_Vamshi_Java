class OneSecondDelay{
    public static void main(String[] args) {

        Hello hello=new Hello();
        hello.start();
    }
}

class Hello extends Thread{
    public void run(){
        for(int i=1;i<=10;i++){
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}