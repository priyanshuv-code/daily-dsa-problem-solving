class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder ans=new StringBuilder();
        Stack<Character> st=new Stack<>();
        int n=s.length();
        int balance=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                balance++;
                st.push(ch);
            }
            else if(ch==')'){
                if (balance > 0) {
                    balance--;
                    st.push(ch);
                }
            }
            else{
                st.push(ch);
            }
        }
        while (!st.isEmpty()) {
            char ch = st.pop();

            if (ch == '(' && balance > 0) {
                balance--;
            }
            else {
                ans.append(ch);
            }
        }
        return ans.reverse().toString();
    }
}