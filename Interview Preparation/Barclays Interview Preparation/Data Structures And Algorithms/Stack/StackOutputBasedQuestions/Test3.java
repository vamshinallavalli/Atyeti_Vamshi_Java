package StackOutputBasedQuestions;

import java.util.*;

public class Test3 {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>(3, 2);

        v.add(1);
        v.add(2);
        v.add(3);
        v.add(4);

        System.out.println(v.capacity());
    }
}
