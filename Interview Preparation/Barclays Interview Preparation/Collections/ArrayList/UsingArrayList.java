package ArrayList;

import java.util.ArrayList;

public class UsingArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        int count=0;
        for(int i=0;i<5;i++){
            arrayList.add(count++);
        }

        System.out.println(arrayList);
    }
}
