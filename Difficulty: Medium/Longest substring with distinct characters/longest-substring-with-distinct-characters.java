class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        int n=s.length();
        HashMap<Character,Integer>map=new HashMap<>();
        int i=0;
        int j=0;
        int max=Integer.MIN_VALUE;
        while(j<n){
            char ch=s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
            while(map.get(ch)>1){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i))==0){
                    map.remove(s.charAt(i));
                }
                i++;
            }
            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}