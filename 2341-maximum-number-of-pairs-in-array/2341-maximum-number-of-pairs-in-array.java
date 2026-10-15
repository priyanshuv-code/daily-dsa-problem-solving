class Solution {
    public int[] numberOfPairs(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int [] ans=new int [2];
        int cnt=0;
        for(int i=0;i<n;i++){
            int ele=nums[i];
            boolean b=false;
            if(map.containsKey(ele)){
                if(map.get(ele)==1){
                    map.remove(ele);
                    cnt++;
                    b=true;
                }
            }
            if(!b){
                map.put(ele,1);
            }
        }
        ans[0]=cnt;
        ans[1]=nums.length-cnt*2;
        return ans;
    }
}