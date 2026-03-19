class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        
        ArrayList<Integer> ans =new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();
        
        int i=0;
        int j=0;
        while(j<arr.length){
            if(arr[j]<0){
                queue.add(arr[j]);
            }            
            if(j-i+1<k){
                j++;
            }
            
            else if(j-i+1==k){
                if(queue.isEmpty()){
                    ans.add(0);
                }
                else{
                    ans.add(queue.peek());
                }
                if(!queue.isEmpty() && arr[i]==queue.peek()){
                    queue.poll();
                }
                i++;
                j++;
            }
        }
        return ans;
   
    }
}