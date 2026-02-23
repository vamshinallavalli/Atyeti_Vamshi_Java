package StackOutputBasedQuestions;

import java.util.*;

public class Test5 {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(10);
        s.push(20);
        s.push(30);

        s.add(1, 99);
        System.out.println(s);
    }
}
