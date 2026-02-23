package StackOutputBasedQuestions;

import java.util.Stack;

public class Stack2 {
    public static void main(String[] args) {
        Stack stack=new Stack();

        stack.push(15);
        stack.push(20);
        stack.push(35);

        System.out.println(stack.peek()); // 35

        stack.pop();

        System.out.println(stack.peek()); // 20
        System.out.println(stack.size()); //  2

        stack.push(5);

        System.out.println(stack.peek()); // 5
        System.out.println(stack.isEmpty()); // false
    }
}
