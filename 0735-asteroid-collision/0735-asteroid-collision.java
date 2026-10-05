class Solution {
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> st=new Stack<>();
        int n=a.length;
        for(int i=0;i<n;i++){
            boolean dis=false;
            while(!st.isEmpty() && a[i]<0 && st.peek()>0){
                if(Math.abs(st.peek())<Math.abs(a[i])){
                    st.pop();
                }
                else if(Math.abs(st.peek())>Math.abs(a[i])){
                    dis=true;
                    break;
                }
                else{
                    st.pop();
                    dis=true;
                    break;
                }
            }
            if(!dis){
                st.push(a[i]);
            }
        }
        int [] ans=new int[st.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }
}