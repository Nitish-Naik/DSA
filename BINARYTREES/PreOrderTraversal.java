class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class PreOrderTraversal {
    Node root;
    public PreOrderTraversal() {
        root = null;

    }
    public PreOrderTraversal(int data) {
        root = new Node(data);
    }

    public static void preOrderTraversal(Node node) {
        // The root node of the subtree is visited first.
        // Then the left subtree  is traversed.
        // At last, the right subtree is traversed.
        if(node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
    public static void main(String[] args) {
        PreOrderTraversal tree = new PreOrderTraversal(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);

        tree.preOrderTraversal(tree.root);
        System.out.println();
    }
}
