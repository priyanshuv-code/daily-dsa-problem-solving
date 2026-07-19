class Solution {
    public int countPrimes(int n) {
        boolean [] vis=new boolean[n];
        for(int i=2;i<n;i++)vis[i]=true;

        for(int i=2;i<n;i++){
            if(vis[i]){
                for(int j=2*i;j<n;j+=i){
                    vis[j]=false;
                }
            }
        }
        int ans=0;
        for(int i=0;i<vis.length;i++){
            if(vis[i])ans++;
        }
        return ans;
    }
}