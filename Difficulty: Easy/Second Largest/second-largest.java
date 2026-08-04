class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        int p=pq.poll();
        while(!pq.isEmpty() && pq.peek()==p){
            pq.poll();
        }
        if(pq.isEmpty())return -1;
        return pq.poll();
    }
}