class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];

        int total = 0;
        int max = nums[0];

        for(int num : nums){
            total += num;
            max = Math.max(max , total);
            if(total < 0){
                total = 0;
            } 
        }

        return max;
    }
}