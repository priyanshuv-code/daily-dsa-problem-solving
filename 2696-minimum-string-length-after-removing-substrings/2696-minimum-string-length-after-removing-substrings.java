class Solution {
    public int minLength(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
                if(!st.isEmpty() && ((st.peek()=='A' && ch=='B') || (st.peek()=='C' && ch=='D'))){
                    st.pop();
                }
               else{
                st.push(ch);
               }
        }
        return st.size();
    }
}