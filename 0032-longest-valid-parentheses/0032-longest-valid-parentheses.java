class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        int n = s.length();
        int ans = 0;

        int j = 0;

        while (j < n) {
            char ch = s.charAt(j);

            if (ch == '(') {
                st.push(j);
            } else {
                st.pop();

                if (st.isEmpty()) {
                    st.push(j);
                } else {
                    ans = Math.max(ans, j - st.peek());
                }
            }

            j++;
        }

        return ans;
    }
}