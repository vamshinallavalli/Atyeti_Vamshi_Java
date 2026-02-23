class Parent {
    static void m(int i) {
        System.out.println("Parent int");
    }
}

class Child extends Parent {
    static void m(int i) {
        System.out.println("Child int");
    }

    public static void main(String[] args) {
        Parent p = new Child();
        p.m(10);
    }
}


//class Parent {
//    void m(Object o) {
//        System.out.println("Parent Object");
//    }
//}
//
//class Child extends Parent {
//    void m(String s) {
//        System.out.println("Child String");
//    }
//
//    public static void main(String[] args) {
//       // Child c = new Child();
//        Parent c=new Child();
//        c.m("Hello");
//    }
//}
