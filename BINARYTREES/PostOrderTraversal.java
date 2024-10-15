class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right= null;
    }
}
public class PostOrderTraversal {
    Node root;

    public PostOrderTraversal() {
        root = null;
    }

    public PostOrderTraversal(int data) {
        root = new Node(data);
    }

    public static void postOrderTraversal(Node node) {
        if(node == null) {
            return;
        }

        // The left subtree is traversed first
        // Then the right subtree is traversed
        // Finally, the root node of the subtree is traversed

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }
    public static void main(String[] args) {
        PostOrderTraversal tree = new PostOrderTraversal(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);

        tree.postOrderTraversal(tree.root);
        System.out.println();
    }
    
}