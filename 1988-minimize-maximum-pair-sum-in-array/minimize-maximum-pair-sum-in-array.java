class Solution {
    int MAX_VAL = 100000;
    
    public int minPairSum(int[] nums) {
        int n = nums.length;
        int [] count = new int [MAX_VAL + 1];
        int res = 0;
        
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }
        
        for (int lo = 0, hi = MAX_VAL; lo <= hi;) {
            while (lo <= hi && count[lo] == 0) {
                lo++;
            }
            
            while (hi >= lo && count[hi] == 0) {
                hi--;
            }
            
            if (lo <= hi) {
                res = Math.max(res, lo + hi);
                count[lo]--;
                count[hi]--;
            }
        }
        
        return res;
    }
}