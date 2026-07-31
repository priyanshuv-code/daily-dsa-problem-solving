class Pair implements Comparable<Pair>{
    int ele;
    int freq;
    Pair(int ele,int freq){
        this.ele=ele;
        this.freq=freq;
    }
    public int compareTo(Pair p){
        if(this.freq==p.freq){
            return this.ele-p.ele;
        }
        return this.freq-p.freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] arr, int k) {
         HashMap<Integer,Integer> map=new HashMap<>();
        for(int ele:arr){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        
        for(int key:map.keySet()){
            int freq=map.get(key);
            pq.add(new Pair(key,freq));
            if(pq.size()>k)pq.remove();
        }
        int []ans=new int[pq.size()];
        int idx=pq.size()-1;
        while(pq.size()>0){
            Pair top=pq.remove();
            ans[idx--]=top.ele;
        }
        return ans;
    }
}