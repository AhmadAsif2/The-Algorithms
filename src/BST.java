
public class BST {

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    // O(h)
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }   

        if (root.data > val) {
            root.left = insert(root.left, val);
        }

        else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // O(h)
    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data > key) {
            return search(root.left, key);
        }

        else if (root.data == key) {
            return true;
        }
            
        else {
            return search(root.right, key);
        }
    }

    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // deleting node
    // O(h)
    public static Node delete(Node root, int val) {
        
        if (root.data > val) {
            root.left = delete(root.left, val);
        }
        else if (root.data < val) {
            root.right = delete(root.right, val);
        }
        else {
            // Case 1 no child
            if (root.left == null && root.right == null) return null;
            // Case 2 have 1 child
            else if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            else {
                Node IS = inorderSuccessor(root.right);
                root.data = IS.data;
                root.right = delete(root.right, IS.data);
            }
        }

        return root;
    }

    public static Node inorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;    
    }

    public static void main(String[] args) {
        int[] nodes = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;

        for (int i=0; i<nodes.length; i++) {
            root = insert(root, nodes[i]);
        }

        inorder(root);
        System.out.println();

        if (search(root, 1)) {
            System.out.println("found");
        }
        
        else {
            System.out.println("not found");
        }

        delete(root, 5);
        inorder(root);
        
    }   
}
