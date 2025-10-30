class ImplementingLinkedList{
    public static void main(String[] args) {
        Node head=new Node(10);
        Node temp1=new Node(20);
        Node temp2=new Node(30);


        head.next=temp1;
        temp1.next=temp2;


        printTheList(head);
    }

    public static void printTheList(Node head){
        Node current=head;

        while(current!=null){
            System.out.print(current.data+" -> ");
            current=current.next;
        }
        System.out.print("null");
    }
}



class Node{
    int data;
    Node next;

    Node(int x){
        data=x;
        next=null;
    }
}























//public class ImplementingLinkedList {
//    public static void main(String[] args) {
//        Node head = new Node(10);
//        Node temp1 = new Node(20);
//        Node temp2 = new Node(30);
//        head.next = temp1;
//        temp1.next = temp2;
//
//        printList(head);
//    }
//
//    public static void printList(Node head) {
//        Node current = head;
//        while (current != null) {
//            System.out.print(current.data + " -> ");
//            current = current.next;
//        }
//        System.out.println("null");
//    }
//}
//
//class Node {
//    int data;
//    Node next;
//
//    Node(int x) {
//        data = x;
//        next = null;
//    }
//}