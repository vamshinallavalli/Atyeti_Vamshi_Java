import java.util.ArrayList;

public class ArrayInsertAtIndex {

    public void insertAtIndex(ArrayList<Integer> arr, int index, int val){

        //System.out.println("Before Updated List: "+arr);
        arr.add(index-1,val );
        //System.out.println("Updated List: "+arr);
    }

}
