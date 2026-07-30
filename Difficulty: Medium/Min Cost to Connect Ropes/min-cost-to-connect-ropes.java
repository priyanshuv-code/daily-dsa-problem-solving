class Solution {
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int cost=0;
        for(int ele:arr){
            pq.add(ele);
        }
        while(pq.size()!=1){
            int f=pq.poll();
            int s=pq.poll();
            cost+=f+s;
            pq.add(f+s);
        }
        return cost;
    }
}