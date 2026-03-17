/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        calculate_max(root);
        return max;
    }
    public int calculate_max(TreeNode root){
        if(root==null)return 0;

        int left=Math.max(0,calculate_max(root.left));
        int right=Math.max(0,calculate_max(root.right));

        int currentpath=left+right+root .val;

        max=Math.max(max,currentpath);

        return root.val+(Math.max(left,right));
    }
}