class Solution {
    public static boolean ispallindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            else{
                i++;
                j--;
            }
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int n=s.length();
        int i=0;
        int j=n-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return( ispallindrome(s,i+1,j) ||  ispallindrome(s,i,j-1));
            }
            else{
                i++;
                j--;
            }
        }
        return true;
        
    }
}