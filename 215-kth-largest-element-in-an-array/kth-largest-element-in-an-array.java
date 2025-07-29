class Solution {
    public int findKthLargest(int[] nums, int k) {
       PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // The root of the heap is the k-th largest element.
        return minHeap.peek();
    }
}