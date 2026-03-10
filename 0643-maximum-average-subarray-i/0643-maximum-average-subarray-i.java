class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        int window = 3;
        int total = 0;
        for(int i = 0; i < nums.length; i++){
            if(i < k - 1){
                total += nums[i];
            }else if (i == k -1){
                total += nums[i];
                max = Math.max(max, total);
            }else{
                total += nums[i];
                total -= nums[i - k];
                max = Math.max(max, total);
            }
        }

        double ans = max / k;
        return ans;
    }
}