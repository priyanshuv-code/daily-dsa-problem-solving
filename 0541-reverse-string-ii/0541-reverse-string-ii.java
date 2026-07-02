class Solution {
    public String reverseStr(String s, int k) {

        int n = s.length();
        String ans = "";

        int i = 0;
        int cnt = 0;

        while (i < n) {

            int end = Math.min(i + k, n);

            if (cnt % 2 == 0) {
                for (int j = end - 1; j >= i; j--) {
                    ans += s.charAt(j);
                }
            } else {
                ans += s.substring(i, end);
            }

            i += k;
            cnt++;
        }

        return ans;
    }
}