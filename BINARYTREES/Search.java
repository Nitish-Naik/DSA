
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

public class Search {
    Node root;

    public Search() {
        root = null;
    }
    public Search(int data) {
        root = new Node(data);
    }

    public static void inOrderTraversal(Node root) {
        if(root == null) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }

    public static boolean search(Node root, int tar) {
        if(root == null) {
            return false;
        }

        if(root.data == tar) {
            System.out.println(true);
        }

        return search(root.left, tar);
    }

    public static void main(String[] args) {
        Search tree = new Search(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.inOrderTraversal(tree.root);
    }
}