class Solution {
    public void rotate(int[] nums, int k) {
        int length =nums.length;
        int[] tmp = new int[length];
        k = k % length;

        for(int i = 0; i < nums.length; i++){
            tmp[(i+k) % length] = nums[i];
        }
        for(int i = 0; i <length; i++){
           nums[i] = tmp[i];
        }
    }
}