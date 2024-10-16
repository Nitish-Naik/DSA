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
public class Insertion_and_HeightCalculation {
    Node root;

    public Insertion_and_HeightCalculation() {
        root = null;
    }

    public Insertion_and_HeightCalculation(int data) {
        root = new Node(data);
    }

    public static void Inorder(Node node) {
        if(node == null) {
            return;
        }
        Inorder(node.left);
        System.out.print(node.data + " ");
        Inorder(node.right);
    }

    // insertions

    public void insert(int data) {
        root = insertRec(root,data);
    }

    private static Node insertRec(Node root, int data) {
        if(root == null) {
            root = new Node(data);
            return root;
        }
        if(data < root.data) {
            root.left = insertRec(root.left, data);
        }
        else if(data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    // height
    public static int height(Node root) {
        if(root == null) {
            return 0;
        }
        else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            if(leftHeight > rightHeight) {
                return leftHeight + 1;
            }
            else {
                return rightHeight + 1;
            }
        }
    }


    // Check if two trees are identical
    public boolean areIdentical(Node root1, Node root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) return false;

        return (root1.data == root2.data && areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right));
    }
    public static void main(String[] args) {
        Insertion_and_HeightCalculation tree = new Insertion_and_HeightCalculation(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);

        Inorder(tree.root);

        // tree.insert(0);
        System.out.println();
        // Inorder(tree.root);
        // System.out.println();
        // System.out.println("Inorder traversal of the tree:");
        // Inorder(tree.root);

        // System.out.println("\nHeight of the tree: " + height(tree.root));
        // System.out.println();


        Insertion_and_HeightCalculation tree2 = new Insertion_and_HeightCalculation(1);
        tree2.insert(1);
        tree2.insert(2);
        tree2.insert(3);

        Inorder(tree2.root);
        System.out.println();
        System.out.println(tree.areIdentical(tree.root, tree2.root));
    }
}
