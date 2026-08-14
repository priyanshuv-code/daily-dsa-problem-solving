class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            boolean destroyed = false;

            if (st.isEmpty() || (st.peek() > 0 && asteroids[i] > 0)) {
                st.push(asteroids[i]);
            }
            else if (st.isEmpty() || (st.peek() < 0 && asteroids[i] < 0)) {
                st.push(asteroids[i]);
            }
            else {
                while (!st.isEmpty() && st.peek() > 0 && asteroids[i] < 0) {
                    if (Math.abs(asteroids[i]) > Math.abs(st.peek())) {
                        st.pop();
                    }
                    else if (Math.abs(asteroids[i]) == Math.abs(st.peek())) {
                        st.pop();
                        destroyed = true;
                        break;
                    }
                    else {
                        destroyed = true;
                        break;
                    }
                }

                if (!destroyed) {
                    st.push(asteroids[i]);
                }
            }
        }

        int[] res = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
}