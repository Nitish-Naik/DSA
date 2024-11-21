public class Height {
    static class Node {
        int data;
        Node left, right;
        
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    static int height(Node node) {
        if(node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }


    public static void main(String[] args) {
        Height tree = new Height();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.left = new Node(6);

        System.out.println("Height of Tree: " + tree.height(tree.root));
    }
}
