package StackOutputBasedQuestions;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();
        v.add(10);
        v.add(20);
        v.add(30);

        Enumeration<Integer> e = v.elements();
        while (e.hasMoreElements()) {
            Integer i = e.nextElement();
            if (i == 20) {
                v.add(40);
            }
        }
        System.out.println(v);
    }
}

