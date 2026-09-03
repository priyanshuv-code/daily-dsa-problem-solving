class Solution {
    public int[] asteroidCollision(int[] a) {
        int n=a.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            boolean destroyed = false;
            while(!st.isEmpty() && st.peek()>0 && a[i]<0){
                if(Math.abs(st.peek())<Math.abs(a[i])){
                    st.pop();
                }
                else if(Math.abs(st.peek())>Math.abs(a[i])){
                    destroyed = true;
                    break;
                }
                else{
                    st.pop();
                    destroyed = true;
                    break;
                }
            }
            if (!destroyed) {
                st.push(a[i]);
            }
            
        }
        int []ans=new int[st.size()];
        for (int i = 0; i<st.size(); i++) {
            ans[i] = st.get(i);
        }
        return ans;
    }
}