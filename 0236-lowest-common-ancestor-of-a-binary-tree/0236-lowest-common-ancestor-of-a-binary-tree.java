class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // Base case
        if (root == null) return null;

        // If current node is p or q
        if (root == p || root == q) return root;

        // Search in left and right subtrees
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        // If p and q are found in different subtrees
        if (l != null && r != null) return root;

        // Otherwise return the non-null child
        return (l != null) ? l : r;
    }
}
