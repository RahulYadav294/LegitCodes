class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                low = mid + 1;
            }else{
                high = mid-1;
            }
        }
        return false;
    }
}


/*
class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int cols = matrix[0].length;
        for(int col = 0; col<cols; col++){
            boolean found = binarySearch(matrix,col,target,row);
            if(found){
                return true;
            }
        }
        return false;
    }
    public static boolean binarySearch(int[][] matrix,int col,int target,int row){
        int low = 0;
        int high = row-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(matrix[mid][col] == target){
                return true;
            }
            else if(matrix[mid][col] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }
}
*/