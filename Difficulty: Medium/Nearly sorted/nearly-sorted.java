class Solution {
    public void nearlySorted(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        int idx=0;
        for(int ele:arr){
            pq.add(ele);
            if(pq.size()>k){
                arr[idx++]=pq.poll();
            }
        }
        while(pq.size()!=0){
            arr[idx++]=pq.poll();
        }
    }
}
