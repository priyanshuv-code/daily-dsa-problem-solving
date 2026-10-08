class Solution {
    public String smallestSubsequence(String s) {
     int n=s.length();
        int []last_idx=new int[26];
        boolean [] vis=new boolean[26];
        for(int i=0;i<n;i++){
            last_idx[s.charAt(i)-'a']=i;
        }
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(vis[ch-'a'])continue;

            while(!st.isEmpty() && st.peek()>ch && i<last_idx[st.peek()-'a']){
                vis[st.peek()-'a']=false;
                st.pop();
            }
            st.push(ch);
            vis[ch-'a']=true;
        }
         StringBuilder ans=new StringBuilder();

        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        ans.reverse();
        return ans.toString();
    }
}