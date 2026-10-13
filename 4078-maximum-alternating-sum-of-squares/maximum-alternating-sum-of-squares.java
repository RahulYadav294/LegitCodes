
import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        // Step 1: Replace each number with its square
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }

        // Step 2: Sort the squared values
        Arrays.sort(nums);

        // Step 3: Subtract the smallest half
        // and add the largest half
        long sum = 0;
        int mid = n / 2;

        for (int i = 0; i < mid; i++) {
            sum -= nums[i];
        }

        for (int i = mid; i < n; i++) {
            sum += nums[i];
        }

        return sum;
    }
}
