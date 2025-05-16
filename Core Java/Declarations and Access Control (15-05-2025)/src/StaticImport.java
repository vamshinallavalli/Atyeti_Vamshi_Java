//This feature is known as static imports.
// Static imports can be used when you want to "save typing" while using a class's static members.


//before

/*
public class StaticImport {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println();
    }
}
*/


//after

import static java.lang.System.out;

public class StaticImport{
    public static void main(String[] args) {
        out.println(Integer.MAX_VALUE);
        out.println(Integer.toHexString(42));
    }
}
