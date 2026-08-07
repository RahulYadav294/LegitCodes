class Solution {
    public boolean primeSubOperation(int[] nums) {
        int prev = 0;

        for (int i = 0; i < nums.length; i++) {

            // Try the largest valid prime
            for (int p = nums[i] - 1; p >= 2; p--) {

                if (isPrime(p) && nums[i] - p > prev) {
                    nums[i] -= p;
                    break;
                }
            }

            // Current value must be strictly greater than previous
            if (nums[i] <= prev) {
                return false;
            }

            prev = nums[i];
        }

        return true;
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}