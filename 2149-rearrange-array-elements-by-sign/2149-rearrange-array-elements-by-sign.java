class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int []pos=new int[n/2];
        int []neg=new int[n/2];
        int idx_p=0;
        int idx_n=0;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                pos[idx_p++]=nums[i];
            }
            else{
                neg[idx_n++]=nums[i];
            }
        }
        idx_p=0;
        idx_n=0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                nums[i]=pos[idx_p++];
            }
            else{
                nums[i]=neg[idx_n++];
            }
        }
        return nums;
    }
}