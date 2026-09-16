class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i=0;
        int j=0;
        Deque<Integer> dq=new LinkedList<>();
        int n=nums.length;
        int []ans=new int[n-k+1];
        while(j<n){
            while(!dq.isEmpty() && dq.peekLast()<nums[j]){
                dq.removeLast();
            }
            dq.add(nums[j]);
            if(j-i+1==k){
                ans[i]=dq.peekFirst();
                if(nums[i]==dq.peekFirst()){
                    dq.removeFirst();
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}