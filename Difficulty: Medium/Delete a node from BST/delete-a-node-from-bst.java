class Solution {
    public Node delNode(Node root, int key) {
        if (root == null) return null;

        if (key < root.data) {
            root.left = delNode(root.left, key);
        } 
        else if (key > root.data) {
            root.right = delNode(root.right, key);
        } 
        else {
            // Case 1: 0 child
            if (root.left == null && root.right == null) return null;

            // Case 2: 1 child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Case 3: 2 children
            Node predecessor = max(root.left);
            root.data = predecessor.data;
            root.left = delNode(root.left, predecessor.data);
        }
        return root;
    }

    private Node max(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }
}