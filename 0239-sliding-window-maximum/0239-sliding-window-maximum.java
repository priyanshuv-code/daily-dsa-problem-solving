class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int []ans=new int[nums.length-k+1];
        Deque<Integer> dq=new LinkedList<>();
        int i=0;
        int j=0;
        int idx=0;
        while(j<nums.length){

            if (!dq.isEmpty() && dq.peekFirst() < i) {
                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[j]){
                dq.removeLast();
            }
            dq.addLast(j);
            if(j-i+1<k)j++;
            else if (j-i+1==k){
                ans[idx++]=nums[dq.peekFirst()];
                i++;
                j++;
            }
        }
        return ans;
    }
}