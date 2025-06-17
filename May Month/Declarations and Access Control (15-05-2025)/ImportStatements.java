//import java.util.ArrayList;
import java.util.*;

public class ImportStatements {
    public static void main(String[] args) {
      //  java.util.ArrayList<String> a=new java.util.ArrayList<>();
        // Since we programmers are basically lazy, we like to use other people's clases a LOT , AND we hate to type.

        // import statements to the rescue!

//        ArrayList<String> a=new ArrayList<>();
//        System.out.println(a);

//        ArrayList<String> a=new ArrayList<>();
//        TreeSet<String> t=new TreeSet<>();

        // It's okay to say this:

        ArrayList<String> a=new ArrayList<>();
        java.util.TreeSet<String> a2=new java.util.TreeSet<>();
    }
}

//class ArrayList{
//    public static void main(String[] args) {
//        System.out.println("Fake ArrayList..");
//    }
//}
