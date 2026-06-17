class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        int max=-1;
        int i=0;
        int j=0;
        while(j<n){
            char ch=s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
            while(map.size()>k){
                char ith=s.charAt(i);
                map.put(ith,map.get(ith)-1);
                if(map.get(ith)==0){
                    map.remove(ith);
                }
                i++;
            }
            if(map.size()==k){
                max=Math.max(max,j-i+1);
            }
            j++;
        }
        return max;
    }
}