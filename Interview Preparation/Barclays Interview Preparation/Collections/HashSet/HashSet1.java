package HashSet;

import java.util.HashSet;

public class HashSet1 {
    public static void main(String[] args) {
        HashSet<Integer> set=new HashSet<>();

        for(int i=0;i<10;i++){
            for(int j=i+1;j<10;j++){
                set.add(i);
                set.add(j);
            }
        }

        System.out.println(set);
    }
}
