

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int MOD = 1_000_000_007;
        int[] bitCount = new int[30];

        // Step 1: Count how many numbers contain each bit
        for (int num : nums) {
            for (int i = 0; i < 30; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }

        long ans = 0;

        // Step 2: Construct each of the k largest numbers
        for (int j = 0; j < k; j++) {
            long value = 0;

            for (int i = 0; i < 30; i++) {
                if (bitCount[i] > 0) {
                    value |= (1 << i);
                    bitCount[i]--;
                }
            }

            ans = (ans + value * value) % MOD;
        }

        return (int) ans;
    }
}
