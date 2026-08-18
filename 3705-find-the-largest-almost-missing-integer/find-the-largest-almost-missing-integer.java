class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        // Case 1: every element itself is a window
        if (k == 1) {
            int[] freq = new int[51];

            for (int num : nums) {
                freq[num]++;
            }

            int ans = -1;

            for (int num : nums) {
                if (freq[num] == 1) {
                    ans = Math.max(ans, num);
                }
            }

            return ans;
        }

        // Case 2: the entire array is one window
        if (k == n) {
            int ans = 0;

            for (int num : nums) {
                ans = Math.max(ans, num);
            }

            return ans;
        }

        // Case 3: 1 < k < n
        // Only nums[0] and nums[n-1] can appear in exactly one window.

        int ans = -1;

        int first = nums[0];
        boolean firstUnique = true;

        for (int i = 1; i < n; i++) {
            if (nums[i] == first) {
                firstUnique = false;
                break;
            }
        }

        if (firstUnique) {
            ans = Math.max(ans, first);
        }

        int last = nums[n - 1];
        boolean lastUnique = true;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == last) {
                lastUnique = false;
                break;
            }
        }

        if (lastUnique) {
            ans = Math.max(ans, last);
        }

        return ans;
    }
}