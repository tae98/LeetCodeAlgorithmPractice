class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int left = 0, right = numbers.length -1;
        while(left < right){
            int total = numbers[left] + numbers[right];
            if(total < target){
                left++;
            }else if(total > target){
                right--;
            }else{
                ans[0] = left + 1;
                ans[1] = right + 1;
                break;
            }
        }
        return ans;
    }
}