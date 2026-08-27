class Solution {
    String firstAlphabet(String s) {
        // code here
        StringBuilder ans=new StringBuilder();
        ans.append(s.charAt(0));
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)==' '){
                ans.append(s.charAt(i+1));
            }
        }
        return ans.toString();
    }
}