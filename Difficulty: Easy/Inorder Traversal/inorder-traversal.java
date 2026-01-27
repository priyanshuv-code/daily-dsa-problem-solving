/*
class Node {
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public void pre(Node root,ArrayList<Integer> arr){
        if(root==null) return;
        
        pre(root.left,arr);
        arr.add(root.data);
        pre(root.right,arr);
    }
    
    public ArrayList<Integer> inOrder(Node root) {
        //  code here
        ArrayList<Integer> arr=new ArrayList<>();
        pre(root,arr);
        return arr;
    }
}