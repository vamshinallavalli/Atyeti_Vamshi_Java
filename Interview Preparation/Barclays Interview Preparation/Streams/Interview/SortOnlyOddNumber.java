package Interview;

import java.util.*;
import java.util.stream.Collectors;

class SortOnlyOddNumber{
    public static void main(String[] args) {
        ArrayList<Integer> arr= new ArrayList<>(Arrays.asList(2, 4, 6, 3, 5, 1, 8));

       List<Integer> list= arr.stream().filter(s->s%2!=0).sorted().toList();


       int index=0;

       for(int i=0;i<arr.size();i++){
           if(arr.get(i)%2!=0){
               arr.set(i,list.get(index++));
           }
       }

        System.out.println(arr);


    }
}