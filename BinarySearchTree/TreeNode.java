package Java.BinarySearchTree;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree {
    TreeNode root;

    void insert(int data) {
        root = insertRecursive(root, data);
    }

    private TreeNode insertRecursive(TreeNode current, int data) {
        if (current == null) {
            return new TreeNode(data);
        }

        if (data < current.data) {
            current.left = insertRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = insertRecursive(current.right, data);
        }

        return current;
    }

    void inorder(TreeNode current) {
        if (current == null) {
            return;
        }

        inorder(current.left);
        System.out.print(current.data + " ");
        inorder(current.right);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(8);
        tree.insert(3);
        tree.insert(10);
        tree.insert(1);
        tree.insert(6);

        tree.inorder(tree.root);
        // 1 3 6 8 10
    }
}
