class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int  []ans=new int[2];
        int i=0;
        int j=numbers.length-1;
        int sum=0;
        while(i<j){
            sum=numbers[i]+numbers[j];

            if(sum==target){
                ans[0]=i+1;
                ans[1]=j+1;
                break;
            }
            else if(sum<target){
                sum-=numbers[i];
                i++;
            }
            else{
                sum-=numbers[j];
                j--;
            }
        }
        return ans;
    }
}