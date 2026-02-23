package StackOutputBasedQuestions;

import java.util.*;

public class Methods {

    public static void main(String[] args) {

        // ===============================
        // Creating Vector
        // ===============================
        Vector<Integer> vector = new Vector<>();

        // ===============================
        // 1. Add / Insert Methods
        // ===============================
        vector.add(10);                     // add element at end
        vector.add(20);
        vector.add(1, 15);                  // add at index
        vector.addElement(25);              // legacy method

        vector.addAll(Arrays.asList(30, 35)); // add collection
        vector.addAll(2, Arrays.asList(12, 13));

        // ===============================
        // 2. Access / Get Methods
        // ===============================
        int first = vector.firstElement();   // legacy
        int last = vector.lastElement();     // legacy
        int value = vector.get(2);           // modern

        // ===============================
        // 3. Update / Set Methods
        // ===============================
        vector.set(0, 5);                    // modern
        vector.setElementAt(100, 1);         // legacy

        // ===============================
        // 4. Remove / Delete Methods
        // ===============================
        vector.remove(2);                   // remove by index
        vector.remove(Integer.valueOf(30)); // remove object
        vector.removeElement(35);            // legacy
        vector.removeElementAt(0);           // legacy
        vector.removeAll(Arrays.asList(12)); // remove collection
        vector.clear();                      // remove all
        vector.removeAllElements();          // legacy

        // ===============================
        // Re-adding elements for further demo
        // ===============================
        vector.addAll(Arrays.asList(1, 2, 3, 4, 5));

        // ===============================
        // 5. Search Methods
        // ===============================
        boolean contains = vector.contains(3);
        int index1 = vector.indexOf(3);
        int index2 = vector.lastIndexOf(3);
        boolean found = vector.containsAll(Arrays.asList(2, 3));

        // ===============================
        // 6. Size / Capacity Methods
        // ===============================
        int size = vector.size();
        int capacity = vector.capacity();    // legacy concept
        boolean empty = vector.isEmpty();

        // ===============================
        // 7. Capacity Management (Legacy)
        // ===============================
        vector.ensureCapacity(20);
        vector.trimToSize();
        vector.setSize(3);                   // legacy

        // ===============================
        // 8. Iteration Methods
        // ===============================
        // Enumeration (Legacy)
        Enumeration<Integer> e = vector.elements();
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }

        // Iterator (Fail-Fast)
        Iterator<Integer> it = vector.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // ListIterator
        ListIterator<Integer> listIt = vector.listIterator();
        while (listIt.hasNext()) {
            System.out.println(listIt.next());
        }

        // ===============================
        // 9. Conversion Methods
        // ===============================
        Object[] array1 = vector.toArray();
        Integer[] array2 = vector.toArray(new Integer[0]);

        // ===============================
        // 10. Copy Method (Legacy)
        // ===============================
        Vector<Integer> newVector = new Vector<>();
        newVector.setSize(vector.size());
        Collections.copy(newVector, vector);

        // ===============================
        // 11. Sub List
        // ===============================
        List<Integer> subList = vector.subList(0, 2);

        // ===============================
        // 12. Equals & HashCode
        // ===============================
        boolean isEqual = vector.equals(newVector);
        int hash = vector.hashCode();

        // ===============================
        // 13. Synchronization (Implicit)
        // ===============================
        // All Vector methods are synchronized internally
    }
}
