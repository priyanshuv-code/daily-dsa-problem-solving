class Solution {
    public int kthSmallest(int[] arr, int k) {
        // Code here
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int ele:arr){
            pq.add(ele);
        }
        while(k>1){
            pq.poll();
            k--;
        }
        return pq.peek();
    }
}
