class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // 중간 인덱스 계산

            // 1. 타겟을 찾은 경우
            if (nums[mid] == target) {
                return true;
            }

            // 2. 양끝과 mid 값이 같은 경우 → 회전 여부를 판단할 수 없으니 포인터를 한 칸씩 줄임
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
                continue;
            }

            // 3. 왼쪽 구간이 정렬되어 있는 경우
            if (nums[left] <= nums[mid]) {
                // target이 왼쪽 구간 범위에 속하는 경우 → 오른쪽 절반 제거
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                }
                // target이 왼쪽 구간에 없으면 → 왼쪽 절반 제거
                else {
                    left = mid + 1;
                }
            }
            // 4. 오른쪽 구간이 정렬되어 있는 경우
            else {
                // target이 오른쪽 구간 범위에 속하는 경우 → 왼쪽 절반 제거
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                }
                // target이 오른쪽 구간에 없으면 → 오른쪽 절반 제거
                else {
                    right = mid - 1;
                }
            }
        }

        // 모든 탐색 후에도 target을 찾지 못하면 false
        return false;
    }
}