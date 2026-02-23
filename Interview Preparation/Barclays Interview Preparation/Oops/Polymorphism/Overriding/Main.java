public class Main {
    public static void main(String[] args) {
        Child obj=new Child();
        obj.show();

        Parent obj1=new Child();
        obj1.show();

        Parent obj2=new Parent();
        obj2.show();

        //Child obj=new Parent();

    }
}

class Parent {
   static void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {

    static void show() {
        System.out.println("Child");
    }
}

