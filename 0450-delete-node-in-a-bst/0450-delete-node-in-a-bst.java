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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null )return null;

        if(key<root.val)deleteNode(root.left,key);
        else if(key>root.val)deleteNode(root.right,key);
        else{
            // root node has:- 0 child;
            if(root.left==null && root.right==null) return null;
            // root node has:- 1 child;
            if(root.left==null)return root.right;
            if(root.right==null) return root.left;
            // root node has:- 2 child;

            TreeNode precessodor=max(root.left);
            root.val=precessodor.val;
            root.left=deleteNode(root.left,precessodor.val);
        }
        return root;
    }
    private TreeNode max(TreeNode root){
       while(root.right!=null){
        root=root.right;
       } 
       return root;
    }
}