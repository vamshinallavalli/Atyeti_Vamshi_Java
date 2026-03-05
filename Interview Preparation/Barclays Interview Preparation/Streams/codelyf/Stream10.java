// List of the questions on filter


import java.util.Arrays;
import java.util.List;

public class Stream10 {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(10,15,8,49,25,98,32);

        // Find out all even numbers
        System.out.println(list.stream().filter(s->s%2==0).toList());

        // Find out the First even numbers that exist
        System.out.println(list.stream().filter(s->s%2==0).findFirst());

        // Cube and filter numbers greater than 50
        System.out.println(list.stream().map(s->Math.pow(s,3)).filter(s->s>50).toList());

    }
}
