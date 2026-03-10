class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxA = 0;
        int minH = Integer.MAX_VALUE;
        while(left < right){
            minH = Math.min(height[left], height[right]);
            int width = right - left;
            int area = width * minH;
            maxA = Math.max(maxA, area);
            if(minH == height[left]){
                left++;
            }else{
                right--;
            }
        }
        return maxA;
    }
}