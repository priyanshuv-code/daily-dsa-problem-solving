class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> q=new LinkedList<>();
        int ans[]=new int[n-k+1];
        int i=0;
        int j=0;
        int idx=0;
        while(j<n){
            while(!q.isEmpty() && nums[q.peekLast()]<nums[j]){
                q.pollLast();
            }
            q.addLast(j);
            if(j-i+1<k)j++;
            else if(j-i+1==k){
                ans[idx++]= nums[q.peekFirst()];;
                if(q.peekFirst() == i){
                    q.pollFirst();
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}