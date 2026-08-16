class Solution {
    public boolean isAnagram(String s1, String s2) {
        char []ch1=s1.toCharArray();
        char []ch2=s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        if(ch1.length!=ch2.length)return false;
        for(int i=0;i<ch1.length;i++){
            if(ch1[i]!=ch2[i])return false;
        }
        return true;
    }
}