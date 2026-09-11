class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD=1000000007;
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        // previos smallest ele
        int [] pse=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i]=-1;
            }
            else{
                pse[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        int [] nse=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i]=n;
            }
            else{
                nse[i]=st.peek();
            }
            st.push(i);
        }
        long ans=0;
        for(int i=0;i<n;i++){
            long left=i-pse[i];
            long right=nse[i]-i;

            long contri=(long)arr[i]*left*right;
            ans=(ans+contri)%MOD;
        }
        return (int)ans;
    }
}