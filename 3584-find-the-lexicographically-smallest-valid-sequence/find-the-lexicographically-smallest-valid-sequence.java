class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] last = new int[m];
        Arrays.fill(last, -1);

        // last[j] = earliest index from the right that matches word2[j]
        int i = n - 1;
        int j = m - 1;

        while (i >= 0 && j >= 0) {
            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }
            i--;
        }

        int[] ans = new int[m];
        boolean usedMismatch = false;
        j = 0;

        for (i = 0; i < n && j < m; i++) {

            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j++] = i;
            } else if (!usedMismatch &&
                      (j == m - 1 || i < last[j + 1])) {

                usedMismatch = true;
                ans[j++] = i;
            }
        }

        return j == m ? ans : new int[0];
    }
}



/*
class Solution {

    List<Integer> ans = null;

    public int[] validSequence(String word1, String word2) {

        helper(word1, word2, 0, 0, false, new ArrayList<>());

        if (ans == null) return new int[0];

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    private void helper(String word1, String word2,
                        int i, int j,
                        boolean mismatchUsed,
                        List<Integer> path) {

        // matched whole word2
        if (j == word2.length()) {

            if (ans == null || isSmaller(path, ans)) {
                ans = new ArrayList<>(path);
            }
            return;
        }

        // word1 finished
        if (i == word1.length()) {
            return;
        }

        // ---------- TAKE ----------

        path.add(i);

        if (word1.charAt(i) == word2.charAt(j)) {

            helper(word1, word2,
                    i + 1,
                    j + 1,
                    mismatchUsed,
                    path);

        } else if (!mismatchUsed) {

            helper(word1, word2,
                    i + 1,
                    j + 1,
                    true,
                    path);
        }

        path.remove(path.size() - 1);

        // ---------- SKIP ----------

        helper(word1, word2,
                i + 1,
                j,
                mismatchUsed,
                path);
    }

    private boolean isSmaller(List<Integer> a, List<Integer> b) {

        for (int i = 0; i < a.size(); i++) {

            if (a.get(i) < b.get(i))
                return true;

            if (a.get(i) > b.get(i))
                return false;
        }

        return false;
    }
}
*/