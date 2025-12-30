package Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Iterator2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        Iterator<Integer> it = list.iterator();

        while (it.hasNext()) {
            Integer val = it.next();
            list.add(4);
        }

    }
}
