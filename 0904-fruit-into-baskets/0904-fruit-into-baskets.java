class Solution {
    public int totalFruit(int[] fruits) {
        int n=fruits.length;
        int i=0;
        int j=0;
        int ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(j<n){
            int jth=fruits[j];
            if(map.containsKey(jth)){
                map.put(jth,map.get(jth)+1);
            }
            else{
                map.put(jth,1);
            }
            while(map.size()>2){
                int ith=fruits[i];
                map.put(ith,map.get(ith)-1);
                if(map.get(ith)==0)map.remove(ith);
                i++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}