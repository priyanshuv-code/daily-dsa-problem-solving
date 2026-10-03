class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st=new Stack<>();
        int []nge=new int[nums2.length];
        for(int i=nums2.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<nums2[i]){
                st.pop();
            }
            if(st.isEmpty())nge[i]=-1;
            else nge[i]=st.peek();
            st.push(nums2[i]);
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],nge[i]);
        }
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                nums1[i]=map.get(nums1[i]);
            }
        }
        return nums1;
    }
}