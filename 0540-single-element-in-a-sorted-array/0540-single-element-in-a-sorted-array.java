class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;

            // mid가 짝수면 mid ^ 1 == mid + 1
            // mid가 홀수면 mid ^ 1 == mid - 1
            if (nums[mid] == nums[mid ^ 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];  // 싱글 숫자는 left 위치에 존재
    }
}
