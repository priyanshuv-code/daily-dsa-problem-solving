class Solution {
    public int gcdOfOddEvenSums(int n) {
        int start=0;
        int end=0;
        int s1=1;
        int s2=2;

        for(int i=0;i<n;i++){
            start+=s1;
            end+=s2;

            s1+=2;
            s2+=2;
        }
        int ans=0;
        for(int i=1;i<=Math.min(start,end);i++){ 
            if(start%i==0 && end%i==0) ans=Math.max(ans,i);
        }
        return ans;
    }
}