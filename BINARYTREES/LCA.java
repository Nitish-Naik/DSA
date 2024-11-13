import java.util.ArrayList;

class TreeNode {  // Renamed Node class to TreeNode
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class LCA {

    TreeNode root;

    public LCA() {
        root = null;
    }

    public LCA(int data) {
        root = new TreeNode(data);
    }

    // Method to find the path from root node to given node `n1`.
    public static boolean findPath(TreeNode root, int n1, ArrayList<Integer> path) {
        if (root == null) return false;

        // Add current node to the path
        path.add(root.data);

        // Check if current node is the target node
        if (root.data == n1) return true;

        // Recursively check left and right subtrees
        if (findPath(root.left, n1, path) || findPath(root.right, n1, path)) return true;

        // If not found in either subtree, backtrack
        path.remove(path.size() - 1);  // Remove the node from the path if it's not part of the solution
        return false;
    }

    public static void main(String[] args) {
        // Example tree construction
        LCA tree = new LCA(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);

        // ArrayList to store the path
        ArrayList<Integer> path = new ArrayList<>();

        // Find the path to the node with value 6
        boolean found = findPath(tree.root, 6, path);

        // Output the result
        System.out.println("Path to node 6: " + path);
        System.out.println("Node 6 found: " + found);
    }
}
