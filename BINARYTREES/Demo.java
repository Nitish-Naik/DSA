class Node {
    int data;
    Node left;
    Node right;


    public Node(int data) {
        this.data = data;
        this.left= null;
        this.right= null;
    }
}


public class Demo {
    Node root;

    public Demo() {
        root = null;
    }

    public Demo(int data) {
        root = new Node(data);
    }


    public void inorderTraversal(Node node) {
        if(node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.println(node.data + " ");
        inorderTraversal(node.right);
    }

    public void preorderTraversal(Node node) {
        if(node == null) return;
        System.out.println(node.data);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }
    public void postorderTraversal(Node node) {
        if(node == null) return;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.println(node.data);
    }

    public static void main(String args[]) {
        Demo tree = new Demo(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Inorder traversal:");
        tree.inorderTraversal(tree.root);

        System.out.println("\nPreorder traversal:");
        tree.preorderTraversal(tree.root);

        System.out.println("\nPostorder traversal:");
        tree.postorderTraversal(tree.root);
    }
}