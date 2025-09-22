class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] tmp = new int[nums.length];
        int idx = nums.length - 1;

        while(left <= right){
            int leftVal = nums[left] * nums[left];
            int rightVal = nums[right] * nums[right];

            if( leftVal > rightVal ){
                tmp[idx] = leftVal;
                left++;
            }else{
                tmp[idx] = rightVal;
                right--;
            }
            idx--;
        }
        return tmp;
    }
}