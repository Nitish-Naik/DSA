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

public class InorderTraversal {
    Node root;

    public InorderTraversal() {
        root = null;
    }
    public InorderTraversal(int data) {
        root = new Node(data);
    }
     
    public static void inorderTraversal(Node node) {
        if(node == null) {
            return;

        }
        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }
    public static void main(String[] args) {
        InorderTraversal tree= new InorderTraversal(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);


        tree.inorderTraversal(tree.root);

    }
}