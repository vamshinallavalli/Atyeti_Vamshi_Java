package StackOutputBasedQuestions;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();
        v.add(1);
        v.add(2);
        v.add(3);

        for (Integer i : v) {
            if (i == 2) {
                v.add(4);
            }
        }
        System.out.println(v);
    }
}
