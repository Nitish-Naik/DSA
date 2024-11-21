class Node {
    int data;
    Node left, right;

    Node(int data) {
        data = this.data;
        left = right=null;
    }
}
public class BinaryTreeFromArray {
    Node root;
    Node insertLevelOrder(int a[], int i) {
        if(i >= a.length) return null;

        Node node = new Node(a[i]);
        node.left = insertLevelOrder(a, 2*i+1);
        node.right = insertLevelOrder(a, 2*i+1);

        return node;
    }

    void inorder(Node node) {
        if(node == null) return;

        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        BinaryTreeFromArray tree = new BinaryTreeFromArray();
        int a[] = {1, 2, 3, 4, 5, 6, 7};

        tree.root = tree.insertLevelOrder(a, 0);
        System.out.println("Inorder Traversal : ");
        tree.inorder(tree.root);
    }
}