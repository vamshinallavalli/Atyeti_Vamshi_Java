package ConcurrentCollections;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayList_Example {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(10);
        for(int i : list) System.out.println(i);

    }
}
