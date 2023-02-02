import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static int idx = -1;
    public Node buildTree(int[] nodes) {
        idx++;

        if (nodes[idx] == -1) {
            return null;
        }

        Node node = new Node(nodes[idx]);

        node.left = buildTree(nodes);
        node.right = buildTree(nodes);

        return node;
    }

    // O(N)
    public void preorder(Node root) {
        
        if (root == null) {
            return;
        }
        
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // O(N)
    public void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // O(N)
    public void postorder(Node root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // O(N)
    public void levelOrder(Node root) {

        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {

            Node currNode = q.remove();

            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");

                if (currNode.left != null) {
                    q.add(currNode.left);
                } 

                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    // O(N)
    public int countOfNodes(Node root) {

        if (root == null) return 0;

        int leftNodesSum = countOfNodes(root.left);
        int rightNodesSum = countOfNodes(root.right);

        return leftNodesSum + rightNodesSum + 1;
    }
    
    // O(N)
    public int sumOfNodes(Node root) {

        if (root == null) return 0;

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum + rightSum + root.data;
    }

    // O(N)
    public int heightOfTree(Node root) {

        if (root == null) return 0;

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        int myHeight = Math.max(leftHeight, rightHeight) + 1;

        return myHeight;
    }


    public static void main(String[] args) {
        // preorder sequence 
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        BinaryTree tree =  new BinaryTree();
        Node root = tree.buildTree(nodes);

        System.out.println(root.data);

        // tree.preorder(root);
        // tree.inorder(root);
        // tree.postorder(root);
        tree.levelOrder(root);

        System.out.println("Count of nodes: " + tree.countOfNodes(root));
        System.out.println("Sum of all nodes: " + tree.sumOfNodes(root));
        System.out.println("Height of tree: " + tree.heightOfTree(root));


    }
}
