class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        int n=arr.length;
        Queue<Integer> q=new LinkedList<>();
        List<Integer> ans=new ArrayList<>();
        int i=0;
        int j=0;
        while(j<n){
            if(arr[j]<0){
                q.offer(arr[j]);
            }
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                if(q.isEmpty()){
                    ans.add(0);
                }
                else{
                    ans.add(q.peek());
                }
                if(!q.isEmpty() && arr[i]==q.peek()){
                    q.poll();
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}