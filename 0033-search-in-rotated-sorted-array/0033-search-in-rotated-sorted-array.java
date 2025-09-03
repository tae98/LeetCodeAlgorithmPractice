class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length -1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target){
                return mid;
            }
            //왼쪽이 정렬된경우
            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }

            //오른쪽이 정렬된경우
            if(nums[mid] <= nums[right]){
                if(target <= nums[right] && nums[mid] < target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}