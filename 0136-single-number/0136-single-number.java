class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 1){
            return nums[0];
        }
        int ans = 0;
        for(int i : nums){
            ans = ans ^ i;
        }
        return ans;
    }
}