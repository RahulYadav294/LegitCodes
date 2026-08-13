class Solution {

    public boolean canPartitionKSubsets(int[] nums, int k) {

        int n = nums.length;
        int total = 0;

        for (int i = 0; i < n; i++) {
            total += nums[i];
        }

        if (total % k != 0) return false;

        int target = total / k;

        Boolean[][] dp = new Boolean[n][1 << n];

        return isPossible(nums, k, target, target, 0, 0, dp);
    }

    public boolean isPossible(int[] nums, int m, int target,
                              int orgTarget, int index,
                              int mask, Boolean[][] dp) {

        if (m == 0) return true;

        if (target == 0) {
            return isPossible(nums, m - 1, orgTarget,
                             orgTarget, 0, mask, dp);
        }

        if (index == nums.length) return false;

        // Already solved this state
        if (dp[index][mask] != null) {
            return dp[index][mask];
        }

        boolean ans = false;

        // TAKE
        if ((mask & (1 << index)) == 0 &&
            nums[index] <= target) {

            int newMask = mask | (1 << index);

            ans = isPossible(nums, m,
                             target - nums[index],
                             orgTarget,
                             index + 1,
                             newMask,
                             dp);
        }

        // NOT TAKE
        if (!ans) {
            ans = isPossible(nums, m,
                             target,
                             orgTarget,
                             index + 1,
                             mask,
                             dp);
        }

        // Store result of CURRENT state
        dp[index][mask] = ans;

        return ans;
    }
}