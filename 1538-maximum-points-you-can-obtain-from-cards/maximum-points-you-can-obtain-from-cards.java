class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = 0;
        for(int i = 0; i<n; i++){
            total+=cardPoints[i];
        }
        if(k == n) return total;
        int winSize = n-k;
        int currWinSum = 0;
        for(int i = 0; i<n-k;  i++){
            currWinSum+=cardPoints[i];
        }
        int minSum = currWinSum;
        for(int i = winSize; i<n; i++){
            currWinSum+=cardPoints[i] - cardPoints[i-winSize];
            minSum = Math.min(currWinSum,minSum);
        }
        return total-minSum;
    }
}