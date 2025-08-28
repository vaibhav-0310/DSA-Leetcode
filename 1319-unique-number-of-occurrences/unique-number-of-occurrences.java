class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        Set<Integer> set=map.keySet();
        for(int i=0;i<arr.length;i++){
            int h=map.get(arr[i]);
            for(Integer j:set){
                if(j==arr[i]){
                    continue;
                }
                else if(h==map.get(j)){
                    return false;
                }
            }
        }
        return true;
    }
}