package ArrayDequeue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();

        dq.addLast(10);
        dq.addLast(20);
        dq.addFirst(30);

        // Print deque elements
        for (int x : dq) System.out.print(x + " ");
        System.out.println();

        // Pop from front and back
        dq.removeFirst();
        dq.removeLast();

        // Print deque elements after pop
        for (int x : dq) System.out.print(x + " ");
    }
}
