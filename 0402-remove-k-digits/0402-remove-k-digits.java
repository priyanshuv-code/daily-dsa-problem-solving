class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < num.length(); i++) {

            while(k > 0 && !st.isEmpty() && st.peek() > num.charAt(i)) {
                st.pop();
                k--;
            }

            st.push(num.charAt(i));
        }

        // Remove remaining digits from the end
        while(k > 0) {
            st.pop();
            k--;
        }

        StringBuilder str = new StringBuilder();

        while(!st.isEmpty()) {
            str.append(st.pop());
        }

        str.reverse();

        // Remove leading zeroes
        int i = 0;

        while(i < str.length() - 1 && str.charAt(i) == '0') {
            i++;
        }

        str = new StringBuilder(str.substring(i));

        if(str.length() == 0) {
            return "0";
        }

        return str.toString();
    }
}