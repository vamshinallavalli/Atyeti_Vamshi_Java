package classAndObject;

class Person1 {
    String name;
    int age = 10;
}

//public class Person2 {
//    public static void main(String[] args) {
//        Person1 p1 = new Person1();    // Line 1
//        p1.name = "Alice";           // Line 2
//
//        Person1 p2 = p1;              // Line 3
//        p2.name = "Bob";             // Line 4
//
//        Person1 p3 = new Person1();    // Line 5
//        p3.name = "Charlie";
//
//        System.out.println(p1.name); // prints Bob
//        System.out.println(p2.name); // prints Bob
//        System.out.println(p3.name); // prints Charlie
//    }
//}

public class Person2 {
    public static void main(String[] args) {
        Person1 p1 = new Person1();
        p1.name = "Alice";

        Person1 p2 = p1;
        p2.name = "Bob";

        System.out.println(p1.name);           // Bob
        System.out.println(System.identityHashCode(p1)); // e.g. 1562557361
        System.out.println(System.identityHashCode(p2)); // same number!
        System.out.println(System.identityHashCode(new Person1())); // different number
    }
}


/*

+------------------------------+          +----------------------------------+
|           STACK              |          |              HEAP                |
| (one stack frame: main())    |          |                                  |
+------------------------------+          +----------------------------------+
| p1 ─────┐   (reference)               | Object #1 (address 0x100)        |
|         ├────────────────────────────▶|   name → "Bob"                   |
| p2 ─────┘   (same reference)          |   age  → 10                      |
|                                |       +----------------------------------+
| p3 ───────────────────────────────▶ | Object #2 (address 0x200)        |
|         (different reference)   |     |   name → "Charlie"              |
+------------------------------+          |   age  → 10                      |
                                          +----------------------------------+
 */
