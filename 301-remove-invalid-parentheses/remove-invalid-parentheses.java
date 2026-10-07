
class Solution {
    List<String> result = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {

        int removeOpen = 0;
        int removeClose = 0;

        // Step 1: Count extra '(' and ')'
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                removeOpen++;
            } 
            else if (ch == ')') {
                if (removeOpen > 0) {
                    removeOpen--;
                } 
                else {
                    removeClose++;
                }
            }
        }

        // Step 2: Backtracking
        dfs(s, 0, removeOpen, removeClose, 0, "");

        return result;
    }

    private void dfs(String s, int index,
                     int removeOpen, int removeClose,
                     int balance, String current) {

        // Invalid prefix
        if (balance < 0) {
            return;
        }

        // End of string
        if (index == s.length()) {

            if (removeOpen == 0 &&
                removeClose == 0 &&
                balance == 0) {

                if (!result.contains(current)) {
                    result.add(current);
                }
            }

            return;
        }

        char ch = s.charAt(index);

        // Case 1: '('
        if (ch == '(') {

            // Remove '('
            if (removeOpen > 0) {
                dfs(
                    s,
                    index + 1,
                    removeOpen - 1,
                    removeClose,
                    balance,
                    current
                );
            }

            // Keep '('
            dfs(
                s,
                index + 1,
                removeOpen,
                removeClose,
                balance + 1,
                current + ch
            );
        }

        // Case 2: ')'
        else if (ch == ')') {

            // Remove ')'
            if (removeClose > 0) {
                dfs(
                    s,
                    index + 1,
                    removeOpen,
                    removeClose - 1,
                    balance,
                    current
                );
            }

            // Keep ')' only if it has a matching '('
            if (balance > 0) {
                dfs(
                    s,
                    index + 1,
                    removeOpen,
                    removeClose,
                    balance - 1,
                    current + ch
                );
            }
        }

        // Case 3: letter
        else {

            dfs(
                s,
                index + 1,
                removeOpen,
                removeClose,
                balance,
                current + ch
            );
        }
    }
}