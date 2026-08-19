
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Set<Integer>> map = new HashMap<>();

        // Store reserved seats row-wise
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            map.putIfAbsent(row, new HashSet<>());
            map.get(row).add(col);
        }

        // Initially, every row can fit 2 families
        int ans = 2 * n;

        // Only rows having reservations need to be checked
        for (int row : map.keySet()) {

            Set<Integer> seats = map.get(row);

            boolean left = true;   // 2,3,4,5
            boolean middle = true; // 4,5,6,7
            boolean right = true;  // 6,7,8,9

            for (int seat = 2; seat <= 5; seat++) {
                if (seats.contains(seat)) {
                    left = false;
                    break;
                }
            }

            for (int seat = 4; seat <= 7; seat++) {
                if (seats.contains(seat)) {
                    middle = false;
                    break;
                }
            }

            for (int seat = 6; seat <= 9; seat++) {
                if (seats.contains(seat)) {
                    right = false;
                    break;
                }
            }

            // This row was initially counted as 2.
            // Remove what this row actually cannot accommodate.

            if (left && right) {
                // still 2 → no change
            } 
            else if (left || right || middle) {
                // can fit one family
                ans -= 1;
            } 
            else {
                // cannot fit any family
                ans -= 2;
            }
        }

        return ans;
    }
}