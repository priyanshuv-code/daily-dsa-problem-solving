class Solution {
    public int shipWithinDays(int[] arr, int k) { // arr--> weigth and k-->days
         int n=arr.length; 
        if(k>n) return -1;
        int start = Arrays.stream(arr).max().getAsInt();
        int end = 0;
        int ans=0;
        for(int i=0;i<n;i++){
            end +=arr[i];
        }
        while(start<=end){
            int mid=start+(end-start)/2;
            int count=1;
            int page=0;
            for(int i=0;i<n;i++){
                page+=arr[i];
                if(page>mid){
                    count++;
                    page=arr[i];
                }
            }
            if(count<=k){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
}
