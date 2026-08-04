class Solution {
    public ArrayList<Integer> getAlternates(int arr[]) {
        // Code Here
        int i=0;
        ArrayList<Integer> list=new ArrayList<>();
        while(i<arr.length){
            list.add(arr[i]);
            i=i+2;
        }
        return list;
    }
}