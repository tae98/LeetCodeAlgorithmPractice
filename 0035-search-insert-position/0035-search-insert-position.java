class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // ✅ 이진 탐색 시작: target이 존재하는지 찾기
        while (left <= right) {
            int mid = (left + right) / 2;

            // \U0001f3af target을 정확히 찾은 경우 → 그 위치 반환
            if (nums[mid] == target) {
                return mid;
            }

            // target이 mid보다 크면 → 오른쪽 탐색
            if (nums[mid] < target) {
                left = mid + 1;
            }
            // target이 mid보다 작으면 → 왼쪽 탐색
            else {
                right = mid - 1;
            }
        }

        // \U0001f51a target이 존재하지 않을 경우,
        // left는 target이 "삽입될 위치"를 가리킴
        return left;
    }
}
