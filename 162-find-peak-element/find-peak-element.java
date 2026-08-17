class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        if (n == 1) {
            return 0;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check left boundary
            if (mid == 0) {
                if (nums[mid] > nums[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }

            // Check right boundary
            else if (mid == n - 1) {
                if (nums[mid] > nums[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }

            // Normal middle element
            else if (nums[mid] > nums[mid - 1] &&
                     nums[mid] > nums[mid + 1]) {
                return mid;
            }

            // Going uphill → peak is right
            else if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            }

            // Going downhill → peak is left
            else {
                high = mid - 1;
            }
        }

        return -1;
    }
}