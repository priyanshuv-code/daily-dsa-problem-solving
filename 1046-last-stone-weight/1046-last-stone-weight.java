class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
       for(int nums:stones){
        pq.add(nums);
       } 
       while(pq.size()>1){
        int f=pq.poll();
        int s=pq.poll();
        if(f==s)continue;
        else{
            pq.add(f-s);
        }
       }
       if(pq.size()<1)return 0;
       return pq.peek();
    }
}