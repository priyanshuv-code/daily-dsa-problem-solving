class Solution {
    public int totalFruit(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();

        int n=arr.length;
        int count=2;
        int i=0;
        int max=Integer.MIN_VALUE;
        for(int j=0;j<n;j++){
            if(map.containsKey(arr[j])){
                map.put(arr[j],map.get(arr[j])+1); 
            }
            else{
                map.put(arr[j],1);
                count--;
            }
            while(count<0){
                map.put(arr[i],map.get(arr[i])-1);
                if(map.get(arr[i])==0){
                    map.remove(arr[i]);
                    count++;
                }
                i++;
            }
            max=Math.max(max,j-i+1);
        }
        return max;
        
    }
}