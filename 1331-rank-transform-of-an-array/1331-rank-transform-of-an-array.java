class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int []copy=arr.clone();
        Arrays.sort(copy);
         // Reverse the array
        int l = 0, r = copy.length - 1;
        while (l < r) {
            int temp = copy[l];
            copy[l] = copy[r];
            copy[r] = temp;
            l++;
            r--;
        }
        HashSet<Integer> set=new HashSet<>();
        for(int val:copy){
            set.add(val);
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        int val=set.size();
        for(int i=0;i<copy.length;i++){
            if(i==0) map.put(copy[i],val);
            else if(copy[i-1]==copy[i])continue;
            else map.put(copy[i],val);
            val--;
        }
        int []ans=new int[arr.length];
        for(int i=0;i<ans.length;i++){
            ans[i]=map.get(arr[i]);
        }
        return ans;
    }
}