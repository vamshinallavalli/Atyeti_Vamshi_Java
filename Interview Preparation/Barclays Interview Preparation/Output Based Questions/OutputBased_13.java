public class OutputBased_13 {
        public static void change(StringBuilder sb) {
            sb.append(" Krishna");
        }
        public static void main(String[] args) {
            StringBuilder sb = new StringBuilder("Vamshi");
            change(sb);
            System.out.println(sb);
        }
    }
































    /*



    Java is pass-by-value, but for objects, the value passed is the reference.

Both main() and change() point to the same StringBuilder object in memory.

StringBuilder is mutable, so append() modifies the same object, not a new one.







   In Java, everything is passed by value, including object references.

  sb in main() holds a reference to the StringBuilder object.

  When passed to change(), a copy of that reference is passed, now both sb in main() and sb in
change() point to the same object in memory.

sb.append(" Krishna") changes the actual object in memory, not the reference variable. so the change is
visible even after the method ends.

So, System.out.println(sb) prints Vamshi Krishna.
     */