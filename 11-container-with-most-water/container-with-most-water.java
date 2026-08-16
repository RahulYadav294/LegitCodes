class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int low = 0;
        int high = height.length-1;
        while(low <= high){
            int width = high - low;
            int water = Math.min(height[low],height[high]);
            max  =  Math.max(max,water * width);
            if(height[low] < height[high]){
                low++;
            }else{
                high--;
            }
        }
        return max;
    }
}