class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> st=new Stack<>();
        int cnt=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(ch);
                cnt++;
            }
            else if(ch==')'){
                if(cnt>0){
                    st.push(ch);
                    cnt--;
                }
            }
            else st.push(ch);
        }
        StringBuilder ans=new StringBuilder();
        while(!st.isEmpty()){
            char top=st.pop();
            if(top=='(' && cnt>0){
                cnt--;
            }
            else{
                ans.append(top);
            }
        }
        return ans.reverse().toString();
    }
}