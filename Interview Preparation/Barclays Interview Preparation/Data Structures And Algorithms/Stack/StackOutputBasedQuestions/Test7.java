package StackOutputBasedQuestions;

import java.util.Stack;

class Test7 extends Thread {
    static Stack<Integer> s = new Stack<>();

    public void run() {
        for(int i = 0; i < 1000; i++)
            s.push(i);
    }

    public static void main(String[] args) throws Exception {
        Test7 t1 = new Test7();
        Test7 t2 = new Test7();

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(s.size());
    }
}

