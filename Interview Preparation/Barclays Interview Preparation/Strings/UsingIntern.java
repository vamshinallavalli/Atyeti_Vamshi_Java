public class UsingIntern {
    public static void main(String[] args) {
        //The intern() method Puts the string in the pool if it is not already there, or gives the pooled
        //version. So even if we create a string using new, we can save the string in the pool.

        String s4=new String("Vamshi");
        String s5="Vamshi";

        //s4=s4.intern();

        System.out.println(s4.equals(s5));

        System.out.println(s4==s5);





        String s1 = new String("hello");// Creates a new string object in the heap
        String s2 = s1.intern(); // Adds "hello" to the pool and returns a referenc to it
        String s3 = "hello";
// Directly references the "hello" in the string pool
        System.out.println(s1 == s2); // false (s1 is in heap, s2 is in pool)
        System.out.println(s2 == s3); // true (both refer to the same object in the pool)
    }
}
