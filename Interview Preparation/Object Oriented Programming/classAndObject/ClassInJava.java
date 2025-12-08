package classAndObject;

public class ClassInJava {
    public static void main(String[] args) {
/*

1. What is a Class?

A class is a blueprint or template for creating objects.
It defines properties (fields/attributes) and behaviors (methods).
The class itself does not occupy space for instance data — it’s just a definition.

        Continue..... Person Class
 */

        Person p1 = new Person();  // Object creation

/*

    What Happens                                     Where in Memory

new Person() -> Creates the object                   Heap

Initializes instance variables (name=null, age=0)    Inside the object on the heap

p1= -> Stores the reference (memory address)         Stack (local variable) or heap (if filled
to the object                                        of another object)



3. Heap Allocation

The heap is a region of memory used for dynamic allocation.
All objects in Java/C#/Python/etc. live on the heap.
Each new allocates a chunk of memory on the heap sufficient for all instance fields.

textHeap:
       +-----------------+
0x1A2B |   Person object  | ← name = null
       |   age = 0        |     (actual address e.g., 0x1A2B3F00)
       +-----------------+
4. Reference Storage

Variables that hold objects do not contain the object itself — they contain a reference (essentially a pointer/address).
In Java/C#, reference variables are stored:
On the stack if they are local variables
On the heap if they are fields inside another object


Java

Person p1 = new Person();   // p1 is a reference variable on stack
p1.name = "Alice";

Person p2 = p1;             // p2 now points to the SAME object
p2.name = "Bob";

System.out.println(p1.name); // Prints "Bob" → both refer to same object

Visual:
textStack:                        Heap:
+--------+                   +-----------------+
| p1 ────────┐                |   Person object  |
| p2 ────────┼──────────────▶ | name = "Bob"     |
+--------+   │                | age = 0          |
             └────────────────┘                 |



             see Person2 class
 */

    }
}
