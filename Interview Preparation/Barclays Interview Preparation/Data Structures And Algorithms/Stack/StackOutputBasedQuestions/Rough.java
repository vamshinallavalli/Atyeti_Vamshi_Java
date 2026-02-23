package StackOutputBasedQuestions;

import java.util.Iterator;
import java.util.Stack;

public class Rough {
    public static void main(String[] args) {
        //Vector v=new Vector();

        Stack v=new Stack();



//        v.add(5);
//        v.add(9);
//        v.add(99);

        v.push(5);
        v.push(9);
        v.push(99);

        System.out.println(v.peek());

        for(Object x:v){
            System.out.println(x+" ");
        }

        Iterator iterator=v.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
