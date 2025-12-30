package HashTable;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UsingHashTable {
    public static void main(String[] args) {
       // Hashtable<Integer,Integer> hashtable = new Hashtable<>();

        ConcurrentHashMap<Integer,Integer> hashtable=new ConcurrentHashMap<>();

        hashtable.put(1,1);
        hashtable.put(2,2);
        hashtable.put(3,3);

        Iterator<Map.Entry<Integer, Integer>> iterator = hashtable.entrySet().iterator();

          while (iterator.hasNext())
          {
              iterator.next();
              hashtable.remove(1);
              iterator.remove();
          }

        System.out.println(hashtable);
    }
}
