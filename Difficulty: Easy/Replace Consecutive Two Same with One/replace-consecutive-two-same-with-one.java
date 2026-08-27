class Solution {
    public String removeDuplicates(String s) {
        // code here
        StringBuilder ans=new StringBuilder();
        ans.append(s.charAt(0));
        int n=s.length();
        for(int i=1;i<n;i++){
            if(s.charAt(i)!=s.charAt(i-1)){
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}