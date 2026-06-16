class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int []ans=new int[n-k+1];
        Deque<Integer> q=new LinkedList<>();
        int i=0;
        int j=0;
        while(j<n){
            while(!q.isEmpty() && nums[j]>nums[q.peekLast()]){
                q.removeLast();
            }
            q.add(j);
            if(j-i+1==k){
                ans[i]=nums[q.peekFirst()];
                if(nums[i]==nums[q.peekFirst()]){
                    q.removeFirst();
                }
                i++;
            }
            j++;
        }
        return ans; 
    }
}