class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        HashMap<Character,Integer> map=new HashMap<>();
        int max=-1;
        int i=0;
        int j=0;
        while(j<s.length()){
            char ch=s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
            if(map.size()==k){
                max=Math.max(max,j-i+1);
            }
            else{
                while(map.size()>k){
                    map.put(s.charAt(i),map.get(s.charAt(i))-1);
                    if(map.get(s.charAt(i))==0) map.remove(s.charAt(i));
                    i++;
                }
            }
            j++;
        }
        return max;
    }
}