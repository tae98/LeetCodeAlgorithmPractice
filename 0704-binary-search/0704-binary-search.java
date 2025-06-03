class Solution {
    public int search(int[] nums, int target) {
        // 배열의 시작점(left)과 끝점(right) 초기화
        int left = 0, right = nums.length - 1;

        // left가 right보다 작거나 같을 동안 반복 (탐색 구간이 유효할 때)
        while (left <= right) {
            // 중간 인덱스를 계산
            int mid = (left + right) / 2;

            // 중간값이 타겟과 같다면 인덱스를 반환
            if (nums[mid] == target) {
                return mid;
            }
            // 중간값이 타겟보다 작다면, 타겟은 오른쪽에 있으므로 탐색 범위를 오른쪽 절반으로 좁힘
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            // 중간값이 타겟보다 크다면, 타겟은 왼쪽에 있으므로 탐색 범위를 왼쪽 절반으로 좁힘
            else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        // 탐색 범위를 다 좁혔는데도 찾지 못했을 경우 -1 반환
        return -1;
    }
}
