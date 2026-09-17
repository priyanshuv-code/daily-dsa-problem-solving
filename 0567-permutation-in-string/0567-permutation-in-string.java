class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> map1=new HashMap<>();
        int l1=s1.length();
        int l2=s2.length();
        for(int i=0;i<l1;i++){
            char ch=s1.charAt(i);
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        int i=0;
        int j=0;
        HashMap<Character,Integer> map2=new HashMap<>();
        while(j<l2){
            char ch=s2.charAt(j);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
            if(j-i+1==l1){
                if(map1.equals(map2)){
                    return true;
                }
                char ch1=s2.charAt(i);
                map2.put(ch1, map2.get(ch1) - 1);
                if(map2.get(ch1)==0)map2.remove(ch1);
                i++;
            }
            j++;
        }
        return false;
    }
}