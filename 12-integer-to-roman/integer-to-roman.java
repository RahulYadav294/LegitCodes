class Solution {
    public String intToRoman(int num) {
        // Symbols and their values
        int[] values = {1000, 500, 100, 50, 10, 5, 1};
        char[] symbols = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            // Find how many times current value fits into num
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }

            // Handle subtractive cases like 900 (CM), 400 (CD), 90 (XC), 40 (XL), 9 (IX), 4 (IV)
            if (i % 2 == 0 && i + 2 < values.length) {
                int subtractValue = values[i] - values[i + 2];
                if (num >= subtractValue) {
                    sb.append(symbols[i + 2]).append(symbols[i]);
                    num -= subtractValue;
                }
            }

            if (i % 2 == 1 && i + 1 < values.length) {
                int subtractValue = values[i] - values[i + 1];
                if (num >= subtractValue) {
                    sb.append(symbols[i + 1]).append(symbols[i]);
                    num -= subtractValue;
                }
            }
        }

        return sb.toString();
    }

    
        } 
