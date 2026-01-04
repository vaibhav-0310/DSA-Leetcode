class Solution {
    public int sumFourDivisors(int[] nums) {
        int result = 0;

        for (int num : nums) {
            int count = 0;
            int sum = 0;

            for (int d = 1; d * d <= num; d++) {
                if (num % d == 0) {
                    int other = num / d;

                    if (d == other) {
                        count += 1;
                        sum += d;
                    } else {
                        count += 2;
                        sum += d + other;
                    }

                    // Early break if more than 4 divisors
                    if (count > 4) break;
                }
            }

            if (count == 4) {
                result += sum;
            }
        }

        return result;
    }
}
