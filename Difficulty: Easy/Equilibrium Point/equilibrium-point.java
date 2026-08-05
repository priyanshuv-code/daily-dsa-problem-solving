class Solution {
    public static int findEquilibrium(int arr[]) {
        // code here
        int n=arr.length;
        int []prefix_sum=new int[n];
        int []suffix_sum=new int[n];
        prefix_sum[0]=arr[0];
        for(int i=1;i<n;i++){
            prefix_sum[i]=prefix_sum[i-1]+arr[i];
        }
        suffix_sum[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            suffix_sum[i]=suffix_sum[i+1]+arr[i];
        }
        for(int i=0;i<n;i++){
            if(prefix_sum[i]==suffix_sum[i])return i;
        }
        return -1;
    }
}
