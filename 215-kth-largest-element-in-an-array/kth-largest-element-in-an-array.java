class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            p.add(nums[i]);
        }
        while(p.size()>k){
            p.remove();
        }
        return p.peek();
    }
}