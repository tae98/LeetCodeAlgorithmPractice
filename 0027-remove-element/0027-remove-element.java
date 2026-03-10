class Solution {
    public int removeElement(int[] nums, int val) {
        int ans = 0, idx = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[idx] = nums[i];
                idx++;
                ans++;
            }
        }
        return ans;
    }
}