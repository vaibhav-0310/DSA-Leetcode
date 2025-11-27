import java.util.Arrays;

class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;

        // prefix[i] = sum of nums[0..i-1]
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // minPref[rem] = minimum prefix value seen with index % k == rem
        long[] minPref = new long[k];
        Arrays.fill(minPref, Long.MAX_VALUE);
        minPref[0] = 0L;  // prefix[0] has remainder 0

        long ans = Long.MIN_VALUE;

        // r is the right end (exclusive) of subarray [l, r)
        for (int r = 1; r <= n; r++) {
            int rem = r % k;

            // If we've seen some prefix with same remainder, try using it as l
            if (minPref[rem] != Long.MAX_VALUE) {
                long candidate = prefix[r] - minPref[rem];
                if (candidate > ans) {
                    ans = candidate;
                }
            }

            // Update the minimum prefix for this remainder
            if (prefix[r] < minPref[rem]) {
                minPref[rem] = prefix[r];
            }
        }

        return ans;
    }
}
