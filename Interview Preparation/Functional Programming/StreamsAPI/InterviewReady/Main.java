package InterviewReady;// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;

class Main {
    public static void main(String[] args) {

        // int arr[]={1,2,3,4,5,6,7,8,9};
        //String name="Vamshi";
        // int arr[]={3,2,4,1,7,5};

        // print only even 
        // List<Integer> list=Arrays.stream(arr).filter(s->s%2==0).boxed().toList();

        // frequency of letters
        // Map<Character,Long> map=name.chars().mapToObj(s->(char)s).collect(Collectors.groupingBy(c->c,Collectors.counting()));

        // sort only odd
        // List<Integer> list=Arrays.stream(arr).boxed().filter(s->s%2!=0).sorted().toList();

        // int odd=0;

        // for(int i=0;i<arr.length;i++){
        //     if(arr[i]%2!=0){
        //         arr[i]=list.get(odd++);
        //     }
        // }


        // length of words
        //  List<String> str=Arrays.asList("hello","how","are","you","doing");

        //  List<Integer> list=str.stream().map(s->s.length()).collect(Collectors.toList());

        //int arr[]={1,2,3,4,5,6};

        // adding all elements using reduce
        // long l=Arrays.stream(arr).reduce(0,Integer::sum);

        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are awesome",
                "FlatMap converts streams"
        );

        // convert the list of senetence into the words using flat map
  List<String> list=sentences.stream().flatMap(s->Arrays.stream(s.split(" "))).toList();

        System.out.println(list);
    }
}