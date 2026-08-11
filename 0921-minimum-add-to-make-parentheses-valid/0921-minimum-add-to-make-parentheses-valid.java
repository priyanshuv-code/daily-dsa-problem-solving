class Solution {
    public int minAddToMakeValid(String s) {
        int count=0;
        int balance=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='(')balance++;
            else if(ch==')')balance--;

            if(balance<0){
                count++;
                balance=0;
            }
        }
        return count+balance;
    }
}