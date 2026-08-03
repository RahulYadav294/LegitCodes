class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {

        long low = 1;
        long high = (long) n * Math.min(a, Math.min(b, c));

        long lcmAB = lcm(a, b);
        long lcmAC = lcm(a, c);
        long lcmBC = lcm(b, c);
        long lcmABC = lcm(lcmAB, c);

        while (low < high) {
            long mid = low + (high - low) / 2;

            long count = mid / a
                       + mid / b
                       + mid / c
                       - mid / lcmAB
                       - mid / lcmAC
                       - mid / lcmBC
                       + mid / lcmABC;

            if (count < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return (int) low;
    }

    public long gcd(long a, long b) {
        while (b != 0) {
            long rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }

    public long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}