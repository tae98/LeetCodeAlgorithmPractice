class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // O(log n) 바이너리 서치 반복
        while (left <= right) {
            int mid = (left + right) / 2;

            // 정답 조건: 중간 값이 타겟이면 바로 리턴
            if (nums[mid] == target) {
                return mid;
            }

            // === [1] 왼쪽 절반이 정렬된 경우 ===
            // 회전된 배열에서도 항상 한 쪽은 정렬되어 있음
            if (nums[left] <= nums[mid]) {
                // 이 때 target이 왼쪽 정렬 구간에 있는지 체크
                // ex: [4,5,6,7,0,1,2] 에서 target=5 이고 mid=6이면 왼쪽(4~7) 정렬됨
                if (nums[left] <= target && target < nums[mid]) {
                    // target이 정렬된 왼쪽 구간에 있다면, 오른쪽 무시
                    right = mid - 1;
                } else {
                    // 아니면 왼쪽 무시하고 오른쪽으로 감
                    left = mid + 1;
                }
            }
            
            // === [2] 오른쪽 절반이 정렬된 경우 ===
            else {
                // 오른쪽이 정렬된 경우: nums[mid] < nums[right]
                // target이 오른쪽 정렬 구간에 있는지 확인
                if (nums[mid] < target && target <= nums[right]) {
                    // target이 정렬된 오른쪽 구간에 있으면, 왼쪽 무시
                    left = mid + 1;
                } else {
                    // 아니면 오른쪽 무시하고 왼쪽 탐색
                    right = mid - 1;
                }
            }
        }

        // 반복문 끝났는데 못 찾았으면 -1
        return -1;
    }
}
