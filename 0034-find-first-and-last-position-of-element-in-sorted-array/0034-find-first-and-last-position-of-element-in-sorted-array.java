class Solution {
    public int[] searchRange(int[] nums, int target) {
        // ⛳ 첫 번째 등장 위치와 마지막 등장 위치를 찾음
        int start = lowerBound(nums, target);
        int end = upperBound(nums, target);

        // \U0001f3af target이 존재하지 않으면 [-1, -1] 반환
        if (start == -1 || end == -1) {
            return new int[]{-1, -1};
        }
        return new int[]{start, end};
    }

    // ✅ lowerBound: target 이상이 처음 나오는 위치
    private int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left)/2;

            // target 이하인 경우는 무조건 오른쪽 탐색
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // 예외: left가 배열 끝이거나 target이 존재하지 않을 때
        if (left < nums.length && nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }

    // ✅ upperBound: target보다 큰 값이 처음 나오는 위치
    // → 마지막 target의 위치는 left - 1
    private int upperBound(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left)/2;

            // target 이하라면 더 오른쪽에 있을 수 있으므로 left 확장
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // 예외: target이 배열에 없을 수도 있으므로 검증
        if (left - 1 >= 0 && nums[left - 1] == target) {
            return left - 1;
        } else {
            return -1;
        }
    }
}
