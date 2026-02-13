class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();

        Stack<Integer> st=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() &&arr[i]<=st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                ans.add(-1);
            }
            else{
                ans.add(st.peek());
            }
            st.push(arr[i]); 
        }
        Collections.reverse(ans);
       return ans; 
    }
}
