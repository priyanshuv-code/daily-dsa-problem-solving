class Solution {

    public int find(int[] arr, int start, int end) {
        Stack<Integer> st = new Stack<>();

        int stt = arr[start];

        for (int i = start + 1; i < end; i++) {
            if (arr[i] > stt) {
                st.add(arr[i]);
            }
        }

        return st.size();
    }

    int[] countGreater(int arr[], int indices[]) {

        int n = indices.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = find(arr, indices[i], arr.length);
        }

        return ans;
    }
}