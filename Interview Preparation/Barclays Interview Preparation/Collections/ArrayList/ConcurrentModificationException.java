package ArrayList;

import java.util.ArrayList;

public class ConcurrentModificationException {
    public static void main(String[] args) {
        ArrayList<String> array=new ArrayList<>();

        array.add("A");
        array.add("B");
        array.add("C");

        System.out.println(array);
    }
}
