class Solution {
    class pair{
        int steps;
        int node;
        
        pair(int steps,int node){
            this.steps=steps;
            this.node=node;
        }
    }
    public int minimumMultiplications(int[] arr, int start, int end) {
        // code here
        
        int mod=100000;
        int [] dist=new int[mod];
        
        Arrays.fill(dist,(int)1e9);
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(0,start));
        dist[start]=0;
        
        while(!q.isEmpty()){
            pair curr=q.poll();
            int step=curr.steps;
            int node=curr.node;
            
            if(node==end)return step;
            for(int num:arr){
                int newNode=(node*num)%mod;
                
                if(step+1<dist[newNode]){
                    dist[newNode]=step+1;
                    q.add(new pair(step+1,newNode));
                } 
            }
            
        }
        return -1;
    }
}