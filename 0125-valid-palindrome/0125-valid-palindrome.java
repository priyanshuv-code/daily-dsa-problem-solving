class Solution {
    public boolean isPalindrome(String s) {
        String ans=s.toLowerCase().replaceAll("[^a-z0-9]","");
        int start=0;
        int n=ans.length();
        int end=n-1;
        while(start<end){
            if(ans.charAt(start)!=ans.charAt(end))return false;
            else{
                start++;
                end--;
            }
        }
        return true;
    }
}