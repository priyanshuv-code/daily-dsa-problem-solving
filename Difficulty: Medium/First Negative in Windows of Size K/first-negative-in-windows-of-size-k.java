class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {

        int n = arr.length;
        List<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = 0;

        Deque<Integer> dq = new LinkedList<>();

        while(j < n) {

            if(arr[j] < 0) {
                dq.add(arr[j]);
            }

            if(j-i+1 == k) {

                if(dq.isEmpty()) {
                    ans.add(0);
                }
                else {
                    ans.add(dq.peekFirst());
                }

                if(!dq.isEmpty() && dq.peekFirst() == arr[i]) {
                    dq.removeFirst();
                }

                i++;
            }

            j++;
        }

        return ans;
    }
}