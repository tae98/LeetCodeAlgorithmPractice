class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = lowerBound(nums, target);
        int up = upperBound(nums, target);

        if(low == -1 || up == -1){
            return new int[]{-1, -1};
        }
        return new int[]{low, up};
    }
    private int lowerBound(int[] nums, int target){
        int left = 0, right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        if(left < nums.length && nums[left] == target){
            return left;
        }else{
            return -1;
        }
    }
    private int upperBound(int[] nums, int target){
        int left = 0, right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        if(left - 1 >= 0 && nums[left -1] == target){
            return left - 1;
        }else{
            return -1;
        }
    }
}