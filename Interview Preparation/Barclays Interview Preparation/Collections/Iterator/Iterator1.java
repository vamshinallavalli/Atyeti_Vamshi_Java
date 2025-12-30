package Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;

public class Iterator1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer val = it.next();
            list.add(4);
        }

        //Iterator keeps expectedModCount
        //
        //Structural modification changes modCount
        //
        //Mismatch → ConcurrentModificationException

    }
}
