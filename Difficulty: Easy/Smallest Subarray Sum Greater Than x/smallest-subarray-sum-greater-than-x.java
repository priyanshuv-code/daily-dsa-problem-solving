class Solution {
    public static int smallestSubWithSum(int x, int[] arr) {
        // code here
        int n=arr.length;
        int i=0;
        int j=0;
        int ans=Integer.MAX_VALUE;
        int sum=0;
        while(j<n){
            sum+=arr[j];
            while(sum>x){
                ans=Math.min(ans,j-i+1);
                sum-=arr[i];
                i++;
            }
            j++;
        }
        if(ans==Integer.MAX_VALUE)return 0;
        return ans;
    }
}
