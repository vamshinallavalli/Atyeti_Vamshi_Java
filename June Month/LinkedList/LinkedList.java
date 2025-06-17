public class LinkedList {
    Node head; // head of list

    // Linked list Node. Made static so main() can access it
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Method to print the linked list
    void printList() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    // Main method to create and print linked list
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();

        llist.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        llist.head.next = second;
        second.next = third;

        llist.printList(); // Output: 1 2 3
    }
}