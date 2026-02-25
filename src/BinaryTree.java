import java.util.Scanner;

public class BinaryTree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
    }
    public static void preOrder( Node root ) {
        if( root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static int height(Node root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static Node insert(Node root,int data) {
        if (root == null) return new Node(data);  // Base case

        if (data < root.data)
            root.left = insert(root.left, data);   // Left subtree
        else
            root.right = insert(root.right, data); // Right subtree

        return root;
    }
}
