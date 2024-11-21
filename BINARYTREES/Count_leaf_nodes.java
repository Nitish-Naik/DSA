
public class Count_leaf_nodes {
    static class Node {
        int data;
        Node left, right;
    
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    static int countLeafNodes(Node node) {
        if(node == null) return 0;

        if(node.left == null && node.right == null) return 1;

        return countLeafNodes(node.left) + countLeafNodes(node.right);
    }

    public static void main(String[] args) {
        Count_leaf_nodes tree = new Count_leaf_nodes();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        System.out.println("Number of Leaf Nodes: " + tree.countLeafNodes(tree.root));
    }
}