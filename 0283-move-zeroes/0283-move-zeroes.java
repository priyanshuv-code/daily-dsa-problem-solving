class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        if(n==1)return;
        int idx=0;
        while(idx<n && nums[idx]!=0)idx++;
        if (idx == n || idx == n - 1) return;

        int j = idx + 1;

        while(j<n){
            if(nums[j]!=0){
                nums[idx++]=nums[j];
                nums[j]=0;
            }
            j++;
        }
    }
}
