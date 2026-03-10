class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, ans = Integer.MAX_VALUE, total = 0;

        while(right < nums.length){
            total += nums[right];
            right++;

            while(total >= target){
                ans = Math.min(ans, right - left);
                total -= nums[left];
                left++;
            }
        }
        if(ans == Integer.MAX_VALUE){
            return 0;
        }
        return ans;
    }
}