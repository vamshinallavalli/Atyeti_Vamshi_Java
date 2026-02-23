
public class ConstructorChaining {
    public static void main(String[] args) {
        new B();
    }
}

class A1 {
    A1(int a) {
        System.out.println("A "+a);
    }
}
class B extends A1 {
    B() {
        this(10);
        System.out.println("B Default");
    }
    B(int b) {
        super(b);
        System.out.println("B int");
    }
}
