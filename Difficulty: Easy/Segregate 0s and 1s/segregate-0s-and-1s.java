class Solution {
    void segregate0and1(int[] arr) {
        // code here
        int n=arr.length;
        int i=0;
        for(i=0;i<n;i++){
            if(arr[i]==1){
                break;
            }
        }
        for(int j=i;j<n;j++){
            if(arr[j]==0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
            }
        }
    }
}
