class Solution {
    public int totalFruit(int[] fruits) {
        int n=fruits.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=0;
        int j=0;
        int max=0;
        if(n==1)return 1;
        while(j<n){
            if(map.containsKey(fruits[j])){
                map.put(fruits[j],map.get(fruits[j])+1);
            }
            else{
                map.put(fruits[j],1);
            }

            if(map.size()<=2){
                max=Math.max(max,j-i+1);
            }
            while(map.size()>2){
                map.put(fruits[i],map.get(fruits[i])-1);
                if(map.get(fruits[i])==0)map.remove(fruits[i]);
                i++;
            }
            j++;
        }
        return max;
    }
}