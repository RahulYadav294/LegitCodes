class Solution {
    public boolean isGoodArray(int[] nums) {
        int gcd = 0;

        for (int num : nums) {
            gcd = getGcd(gcd, num);
        }

        return gcd == 1;
    }

    private int getGcd(int a, int b) {
        if (b == 0) return a;
        return getGcd(b, a % b);
    }
}