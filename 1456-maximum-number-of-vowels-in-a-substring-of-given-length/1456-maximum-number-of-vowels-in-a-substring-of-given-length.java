class Solution {
    public int maxVowels(String s, int k) {
        int n=s.length();
        int i=0;
        int j=0;
        int cnt=0;
        int ans=-1;
        while(j<n){
            char ch=s.charAt(j);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                cnt++;
            }
            if(j-i+1==k){
                ans=Math.max(ans,cnt);
                char ch1=s.charAt(i);
                if(ch1=='a' || ch1=='e' || ch1=='i' || ch1=='o' || ch1=='u'){
                    cnt--;
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}