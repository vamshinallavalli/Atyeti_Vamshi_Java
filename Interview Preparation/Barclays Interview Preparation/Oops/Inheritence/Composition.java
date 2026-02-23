public class Composition {
    public static void main(String[] args) {
        Machine obj=new Machine();

        obj.engine();

    }
}


class Vehicle{
    public void start(){
        System.out.println("Vehicle Starting....");
    }
}

class Machine{
    Vehicle obj = new Vehicle();
    public void engine() {
     obj.start();
    }

}


