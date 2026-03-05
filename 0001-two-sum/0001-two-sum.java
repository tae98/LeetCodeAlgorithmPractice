class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> tmp = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(tmp.containsKey(target - nums[i])){
                return new int[]{tmp.get(target - nums[i]), i};
            }
            tmp.put(nums[i], i);
        }
        return new int[]{};
    }
}