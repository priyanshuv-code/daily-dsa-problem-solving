class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n=s.length();
        int m=p.length();
        int []s_arr=new int[26];
        int []p_arr=new int[26];
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<m;i++){
            p_arr[p.charAt(i)-'a']++;
        }
        for(int i=0;i<n;i++){
            s_arr[s.charAt(i)-'a']++;

            if(i>=m){
                s_arr[s.charAt(i-m)-'a']--;
            }
            if(Arrays.equals(s_arr,p_arr)){
                ans.add(i-m+1);
            }
        }
        return ans;
    }
}