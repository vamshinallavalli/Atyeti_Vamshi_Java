
// If a class contains another class as a field, it’s HAS-A.

public class Has_A_Relation {
    public static void main(String[] args) {
        Car obj=new Car();
        obj.drive();
    }
}

class Engine {
    void start() {
        System.out.println("Engine started");
    }
}

class Car {
    Engine engine = new Engine();

    void drive() {
        engine.start();
        System.out.println("Car driving");
    }
}
