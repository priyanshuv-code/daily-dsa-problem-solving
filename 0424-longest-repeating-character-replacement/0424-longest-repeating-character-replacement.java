class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int i=0;
        int j=0;
        int ans=0;
        int max_freq=0;
        HashMap<Character,Integer> map=new HashMap<>();
        while(j<n){
            char jth=s.charAt(j);
            if(map.containsKey(jth)){
                map.put(jth,map.get(jth)+1);
            }
            else{
                map.put(jth,1);
            }
            max_freq=Math.max(max_freq,map.get(jth));
            while((j-i+1-max_freq)>k){
                char ith=s.charAt(i);
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