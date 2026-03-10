class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int idx = 0;
        for(int i = 0; i < nums.length; i++){
            if(set.add(nums[i])){
                nums[idx] = nums[i];
                idx++;
            }
        }
        return idx;
    }
}