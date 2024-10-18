import java.util.ArrayList;
import java.util.List;

class Node {
    int data; 
    Node left;
    Node right;

    public Node(int data) {
        this.data =data;
        this.left = null;
        this.right = null;
    }
}
public class LowestCommonAncestor {

    Node root;

    public LowestCommonAncestor() {
        root = null;
    }

    public LowestCommonAncestor(int data) {
        root = new Node(data);
    }

    // private static ArrayList<Integer> path = new ArrayList<>();
    public static boolean LCA(Node root, int n1, ArrayList<Integer> path) {
        if(root == null) return false;

        path.add(root.data);

        if(root.data == n1 || LCA(root.left, n1, path) || LCA(root.right, n1, path)) return true;

        path.remove(path.size()-1);
        System.out.println(path);
        return false;
    }

    public static void main(String[] args) {
        LowestCommonAncestor tree = new LowestCommonAncestor(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        ArrayList<Integer> path = new ArrayList<>();
        System.out.println(LCA(tree.root, 6, path));

    }
}
