package StackOutputBasedQuestions;

import java.util.*;

public class Test6 {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        for (int i : s) {
            System.out.print(i + " ");
        }
    }
}

