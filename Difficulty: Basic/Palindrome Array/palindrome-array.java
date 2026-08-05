class Solution {
    public static boolean isPalindrome(int[] arr) {
        // code here
        int n=arr.length;
        int i=0;
        int j=n-1;
        while(i<j){
            if(arr[i]!=arr[j])return false;
            else{
                i++;
                j--;
            }
        }
        return true;
    }
}
