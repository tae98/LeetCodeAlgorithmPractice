class Solution {
    public void rotate(int[] nums, int k) {
        int[] tmp = new int[nums.length];
        k = k % nums.length;
        for(int i = 0; i < tmp.length; i++){
            tmp[(i+k)%tmp.length] = nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = tmp[i];
        }
    }
}