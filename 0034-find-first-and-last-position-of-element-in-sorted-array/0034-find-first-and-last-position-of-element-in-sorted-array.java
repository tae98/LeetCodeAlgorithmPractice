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
            // \U0001f3af nums[mid]가 target보다 크거나 같으면
            //    → mid도 후보일 수 있으므로 오른쪽을 mid로 좁힘
            //    (target 이상이 더 왼쪽에 있을 수 있음)
            if(nums[mid] >= target){
                right = mid;
            }else{
                // \U0001f3af nums[mid] < target이면 target은 무조건 오른쪽에 있음
                //    → left를 mid + 1로 옮김
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

        // \U0001f3af nums[mid]가 target보다 작거나 같으면
        //    → target보다 큰 값은 오른쪽에 있음
        //    → left를 mid + 1로 확장
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target){
                left = mid + 1;
            }else{
                // \U0001f3af nums[mid] > target이면
                //    → mid는 target 초과값의 후보이므로
                //      right를 mid로 좁힘
                right = mid;
            }
        }
        // \U0001f449 left는 target보다 큰 값의 첫 인덱스
        // 따라서 target의 마지막 인덱스는 left - 1
        if(left - 1 >= 0 && nums[left -1] == target){
            return left - 1;
        }else{
            return -1;
        }
    }
}