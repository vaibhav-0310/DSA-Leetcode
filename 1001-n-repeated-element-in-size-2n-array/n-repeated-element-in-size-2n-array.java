class Solution {
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=nums.length/2;
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
            hm.put(nums[i],hm.get(nums[i])+1);
            }
            else{
                hm.put(nums[i],1);
            }
        }
        for(Map.Entry<Integer, Integer> entry:hm.entrySet()){
            int e=entry.getValue();
            int f=entry.getKey();
            if(e==n){
                return f;
            }
        }
        return 0;
    }
}