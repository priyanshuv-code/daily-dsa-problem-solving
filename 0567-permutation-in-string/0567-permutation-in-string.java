class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> map1=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            map1.put(s1.charAt(i),map1.getOrDefault(s1.charAt(i),0)+1);
        }
        HashMap<Character,Integer> map2=new HashMap<>();
        int i=0;
        int j=0;
        while(j<s2.length()){
            map2.put(s2.charAt(j),map2.getOrDefault(s2.charAt(j),0)+1);
            if(j-i+1>s1.length()){
                map2.put(s2.charAt(i),map2.getOrDefault(s2.charAt(i),0)-1);
                if(map2.get(s2.charAt(i))==0)map2.remove(s2.charAt(i));
                i++;
            }
            if(j-i+1==s1.length()){
                if(map1.equals(map2)){
                    return true;
                }
            }
            j++;
        }
        return false;

    }
}