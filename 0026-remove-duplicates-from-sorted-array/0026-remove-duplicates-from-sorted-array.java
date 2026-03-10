class Solution {
    public int removeDuplicates(int[] nums) {
        int idx = 1;

        for(int i = 1; i < nums.length ; i++){
            int left = i - 1;
            if(nums[i] != nums[left]){
                nums[idx] = nums[i];
                idx++;
            }
        }
        return idx;
    }
}