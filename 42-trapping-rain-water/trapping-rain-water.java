class Solution {
    public static int trap(int[] height) {
        int n = height.length;
       int totalWaterTrapped = 0;
       int left = 0;
       int right = n-1;
       int leftMax = 0,rightMax = 0;
       while(left < right){
        if(height[left] < height[right]){
            if(height[left] >= leftMax){
                leftMax = height[left];
            }
            else{
               totalWaterTrapped+=leftMax - height[left]; 
            }
            left++;
        }
        else{
            if(height[right] >= rightMax){
                rightMax = height[right];
            }
            else{
                totalWaterTrapped += rightMax - height[right];
            }
            right--;
        }
       }
        return totalWaterTrapped;
    }
    
}