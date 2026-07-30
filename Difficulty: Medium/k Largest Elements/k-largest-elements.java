class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(int ele:arr){
            pq.add(ele);
            if(pq.size()>k)pq.poll();
        }
        ArrayList<Integer> list=new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }
        Collections.reverse(list);
        return list;
    }
}
