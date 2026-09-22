class Solution {
    public int countSubstr(String s, int k) {
        //  code here
        return g(s,k)-g(s,k-1);
    }
    public int g(String s, int k){
        HashMap<Character,Integer> map=new HashMap<>();
        int i=0;
        int j=0;
        int ans=0;
        int cnt=0;
        while(j<s.length()){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            while(map.size()>k){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i))==0)map.remove(s.charAt(i));
                i++;
            }
            
            cnt+=j-i+1;
            j++;
        }
        return cnt;
    }
}