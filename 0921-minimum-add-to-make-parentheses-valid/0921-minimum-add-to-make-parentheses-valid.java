class Solution {
    public int minAddToMakeValid(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            boolean b=false;
            if(!st.isEmpty() && st.peek()=='(' && ch==')'){
                st.pop();
                b=true;
            }
            if(!b){
                st.push(ch);
            }
        }
        return st.size();
    }
}