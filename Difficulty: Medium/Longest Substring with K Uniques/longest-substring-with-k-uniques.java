class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int n=s.length();
        int i=0;
        int ans=-1;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int j=0;j<n;j++){
            char ch=s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
            while(map.size()>k){
                char left=s.charAt(i);
                if(map.containsKey(left)){
                    map.put(left,map.get(left)-1);
                }
                if(map.get(left)==0)map.remove(left);
                i++;
            }
            if(map.size()==k){
                ans=Math.max(ans,j-i+1);
            }
        }
        return ans;
    }
}