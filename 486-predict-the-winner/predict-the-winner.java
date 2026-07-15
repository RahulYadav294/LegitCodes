class Solution {

    static final int ARIA = 0;
    static final int BEN = 1;

    public boolean predictTheWinner(int[] nums) {

        int total = 0;
        for (int x : nums)
            total += x;

        int ariaScore = helper(nums, 0, nums.length - 1, ARIA);

        return ariaScore >= total - ariaScore;
    }

    public int helper(int[] nums, int left, int right, int turn) {

        if (left > right)
            return 0;

        if (turn == ARIA) {

            int takeLeft = nums[left] + helper(nums, left + 1, right, BEN);

            int takeRight = nums[right] + helper(nums, left, right - 1, BEN);

            return Math.max(takeLeft, takeRight);

        } else {

            int takeLeft = helper(nums, left + 1, right, ARIA);

            int takeRight = helper(nums, left, right - 1, ARIA);

            return Math.min(takeLeft, takeRight);

        }
    }
}