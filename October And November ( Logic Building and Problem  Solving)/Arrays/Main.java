import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Driver Code for ArrayInsertAtEnd
        ArrayInsertAtEnd arr = new ArrayInsertAtEnd();
        arr.insertAtEnd(new ArrayList<>(Arrays.asList(1, 2, 3, 4)), 5);

        // Driver Code for ArrayInsertAtIndex

        ArrayInsertAtIndex array=new ArrayInsertAtIndex();
        array.insertAtIndex(new ArrayList<>(Arrays.asList(1,2,4,5)),3,3);

        // Driver Code for MaximumIndex
        MaximumIndex array1=new MaximumIndex();
        System.out.println("Max Index is: "+array1.maxIndexDiff(new int[]{1,2,3,4,5}));


    }
}