
// If one class is a type of another, it’s an IS-A relationship.

public class Is_A_Relation {
    public static void main(String[] args) {
        Dog obj=new Dog();
        obj.bark();
        obj.eat();
    }
}

class Animal {
    void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking");
    }
}

