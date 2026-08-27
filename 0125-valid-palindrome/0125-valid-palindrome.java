class Solution {
    public boolean isPalindrome(String s) {
        String ans=s.toLowerCase().replaceAll("[^a-z0-9]","");
        int n=ans.length();
        int start=0;
        int end=n-1;
        while(start<end){
            if(ans.charAt(start)!=ans.charAt(end))return false;
            start++;
            end--;
        } 
        return true;
    }
}