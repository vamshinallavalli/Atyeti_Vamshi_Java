package Tree;

public class BinaryTree
{
    public static void main(String[] args) {
        Node root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.left.left=new Node(40);

        System.out.print("InOrder: ");
        inorder(root);

        System.out.println();
        System.out.print("PreOrder: ");
        preorder(root);

        System.out.println();
        System.out.print("PostOrder: ");
        postorder(root);


    }

    static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }

    static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.key + " ");
        preorder(root.left);
        preorder(root.right);
    }


    static void postorder(Node root) {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.key + " ");
    }


}


class Node{
    int key;
    Node left;
    Node right;

    Node(int k){
        key=k;
    }
}