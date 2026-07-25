class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int last=Integer.MIN_VALUE;;
        int cnt=0;
        for(int i=nums.length-1;i>=0;i--){
            if(last!=nums[i]){
                cnt++;
                last=nums[i];
            }
            else{
                continue;
            }
            if(cnt==3){
                return nums[i];
            }
        }
        if(cnt!=3){
            return nums[nums.length-1];
        }
        else{
            return cnt;
        }
    }
}