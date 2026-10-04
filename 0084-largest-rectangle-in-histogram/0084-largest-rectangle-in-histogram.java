class Solution {
    public int largestRectangleArea(int[] h) {

        Stack<Integer> st = new Stack<>();

        int n = h.length;

        int[] lse = new int[n];
        int[] gse = new int[n];

        // LSE
        lse[0] = -1;
        st.push(0);

        for (int i = 1; i < n; i++) {

            while (!st.isEmpty() && h[st.peek()] >= h[i]) {
                st.pop();
            }

            if (st.isEmpty())
                lse[i] = -1;
            else
                lse[i] = st.peek();

            st.push(i);
        }

        // NSE
        st.clear();

        gse[n - 1] = n;
        st.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {

            while (!st.isEmpty() && h[st.peek()] >= h[i]) {
                st.pop();
            }

            if (st.isEmpty())
                gse[i] = n;
            else
                gse[i] = st.peek();

            st.push(i);
        }

        // Calculate maximum area
        int ans = 0;

        for (int i = 0; i < n; i++) {

            int width = gse[i] - lse[i] - 1;

            int area = h[i] * width;

            ans = Math.max(ans, area);
        }

        return ans;
    }
}