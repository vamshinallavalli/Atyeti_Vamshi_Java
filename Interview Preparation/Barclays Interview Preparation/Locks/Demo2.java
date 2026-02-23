import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo2 {

    public static void main(String[] args) {
        // Write code to demonstrate why CopyOnWriteArrayList is slow for writes]

        CopyOnWriteArrayList copy=new CopyOnWriteArrayList();



        long time=System.currentTimeMillis();
        for(int i=0;i<10000;i++){
        copy.add(i);}

        long end=System.currentTimeMillis()-time;

        System.out.println("Copy on taking....: "+end);


        ArrayList<Integer> list=new ArrayList<>();
        long time1=System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            list.add(i);}

        long end1=System.currentTimeMillis()-time1;

        System.out.println("ArrayList on taking....: "+end1);
    }
}
