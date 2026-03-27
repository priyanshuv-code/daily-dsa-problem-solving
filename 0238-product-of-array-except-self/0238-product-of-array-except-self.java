class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int []pre_pro=new int[n];
        pre_pro[0]=nums[0];
        int []suf_pro=new int[n];
        suf_pro[n-1]=nums[n-1];
        int []ans =new int[n];

        for(int i=1;i<n;i++){
            pre_pro[i]=pre_pro[i-1]*nums[i];
        }

        for(int i=n-2;i>=0;i--){
            suf_pro[i]=suf_pro[i+1]*nums[i];
        }
        ans[0]=suf_pro[0]/pre_pro[0];
        ans[n-1]=pre_pro[n-1]/suf_pro[n-1];
        for(int i=1;i<n-1;i++){
            ans[i]=pre_pro[i-1]*suf_pro[i+1];
        }
        return ans;
    }
}