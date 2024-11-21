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
public class Demo {
    Node root;
    
    public Demo() {
        root = null;
    }

    public Demo(int data) {
        root = new Node(data);
    }
    public static void main(String[] args) {
        Demo tree = new Demo(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        System.out.println("root = " + tree.root.data);
    }
}