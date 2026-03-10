class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int idx = nums.length - 1;
        
        int[] ans = new int[nums.length]; 

        while(left <= right){
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];
            
            if(leftSq >= rightSq){
                ans[idx] = leftSq;
                left++;
                idx--;
            }else{
                ans[idx] = rightSq;
                right--;
                idx--;
            }
        }
        return ans;
    }
}