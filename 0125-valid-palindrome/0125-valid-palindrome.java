class Solution {
    public boolean isPalindrome(String s) {
        String c=s.toLowerCase().replaceAll("[^0-9a-z]","");
        int i=0;
        int j=c.length()-1;
        while(i<j){
            if(c.charAt(i)!=c.charAt(j)){
                return false;
            }
            else{
                i++;
                j--;
            }
        }
        return true;
    }
}