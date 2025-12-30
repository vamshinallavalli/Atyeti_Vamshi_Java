package FailFast;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class UsingHashSet {
    public static void main(String[] args) {
        HashSet<Integer> set=new HashSet<>(Arrays.asList(1,2,3,4));

        Iterator it=set.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
            set.add(9);
        }

    }
}
