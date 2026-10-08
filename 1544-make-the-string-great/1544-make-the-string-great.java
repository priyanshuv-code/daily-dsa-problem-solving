class Solution {
    public String makeGood(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            boolean b=false;
            if(!st.isEmpty() && Character.toLowerCase(ch)==Character.toLowerCase(st.peek()) && st.peek()!=ch){
                st.pop();
                b=true;
            } 
            if(!b){
                st.push(ch);
            }
        }
        StringBuilder ans=new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        ans.reverse();
        return ans.toString();
    }
}