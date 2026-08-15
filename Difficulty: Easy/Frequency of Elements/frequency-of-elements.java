class Solution {
    public ArrayList<ArrayList<Integer>> countFreq(int[] arr) {
        // code here
        int n=arr.length;
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            ans.add(new ArrayList<>(Arrays.asList(entry.getKey(), entry.getValue())));
        }
        return ans;
    }
}