class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int total = 0;

        for(int i = 0; i < k; i++){
            total += nums[i];
        }

        double max = total;

        for(int i = k; i < nums.length; i++){
            total = total - nums[i - k] + nums[i];
            max = Math.max(total, max);
        }

        return max / k;
    }
}