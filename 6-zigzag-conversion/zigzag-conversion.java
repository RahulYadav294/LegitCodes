class Solution {
    public static String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;

        char[][] matrix = new char[numRows][s.length()];
        int row = 0, col = 0;
        boolean goingDown = true;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            matrix[row][col] = ch;

            if (goingDown) {
                if (row == numRows - 1) {
                    goingDown = false;
                    row--; col++;   
                } else {
                    row++;          
                }
            } else {
                if (row == 0) {
                    goingDown = true;
                    row++;          
                } else {
                    row--; col++;
                }
            }
        }

        
        StringBuilder result = new StringBuilder();
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < s.length(); c++) {
                if (matrix[r][c] != 0) {
                    result.append(matrix[r][c]);
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String result = convert(s, numRows);
        System.out.print(result);  
    }
}
