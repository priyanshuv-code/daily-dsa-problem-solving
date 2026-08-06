class Solution {
    public void reverse(int start,int end,int []arr){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int[] arr1 = new int[n - n / 2];
        int[] arr2 = new int[n / 2];
        int idx=0;
        for(int i=0;i<arr1.length;i++){
            arr1[idx++]=nums[i];
        }
        int k=0;
        for(int i=arr1.length;i<n;i++){
            arr2[k++]=nums[i];
        }
        reverse(0,arr1.length-1,arr1);
        reverse(0,arr2.length-1,arr2);
        int s=0;
        int l=0;
        for(int i=0;i<n;i++){
            if(i%2!=0){
                nums[i]=arr2[l++];
            }
            else{
                nums[i]=arr1[s++];
            }
        }
        
    }
}