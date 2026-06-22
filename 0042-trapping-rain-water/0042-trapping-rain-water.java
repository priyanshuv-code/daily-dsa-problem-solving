class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int leftmax=0;
        int rightmax=0;
        int cnt=0;
        int i=0;
        int j=n-1;
        while(i<j){
            if(height[i]<height[j]){
                if(height[i]<leftmax){
                    cnt+=leftmax-height[i];
                }
                else{
                    leftmax=Math.max(leftmax,height[i]);
                }
                i++;
            }
            else{
                if(height[j]<rightmax){
                    cnt+=rightmax-height[j];
                }
                else{
                    rightmax=Math.max(rightmax,height[j]);
                }
                j--;
            }
        }
        return cnt;
    }
}