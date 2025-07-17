class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        // 이진 탐색으로 최소값 위치 좁혀가기
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // mid 값이 right보다 작다 → 최소값은 mid 이하에 있다
            if (nums[mid] < nums[right]) {
                right = mid;
            }
            // mid 값이 right보다 크다 → 최소값은 mid 오른쪽에 있다
            else if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            // mid 값과 right 값이 같으면 → 어느 쪽에 최소가 있는지 확신 불가
            // ⇒ 안전하게 right-- 해서 탐색 범위를 줄인다
            else {
                right--;
            }
        }

        // 최소값은 left가 가리키는 위치에 있음
        return nums[left];
    }
}
