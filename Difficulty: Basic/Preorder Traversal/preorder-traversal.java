/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public void pre(Node root,ArrayList<Integer> ans){
        if(root==null)return;
        ans.add(root.data);
        pre(root.left,ans);
        pre(root.right,ans);
    }
    public ArrayList<Integer> preOrder(Node root) {
        //  code here
        ArrayList<Integer> ans=new ArrayList<>();
        pre(root,ans);
        return ans;
    }
}