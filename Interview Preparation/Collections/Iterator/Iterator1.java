package Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Iterator1 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<>(Arrays.asList(1,2,3,4));


//        arrayList.forEach(x->{
//            if(x==3){
//                arrayList.remove(3); // 5 = 4
//            }
//            System.out.println(arrayList);
//        });

        Iterator<Integer> it=arrayList.iterator();

        while(it.hasNext()){
         if(it.next()==3){ // 4
             arrayList.remove(2); // 5(Iteraor) =5(arraylist)
         }

        }
        System.out.println(arrayList);

    }
}
