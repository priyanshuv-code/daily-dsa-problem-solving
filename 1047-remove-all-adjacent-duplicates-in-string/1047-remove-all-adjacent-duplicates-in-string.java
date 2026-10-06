class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st=new Stack();
        int n=s.length();
        for(int i=0;i<n;i++){
            boolean b=false;
            char ch=s.charAt(i);
            if(!st.isEmpty() && st.peek()==ch){
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