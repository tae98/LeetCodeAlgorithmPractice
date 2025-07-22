class Solution {
    public int maxSubArray(int[] nums) {
        // 길이가 1이면 그냥 그 값이 최대값
        if (nums.length == 1) return nums[0];

        int total = 0;         // 현재까지의 연속 부분합
        int max = nums[0];     // 최대 연속 부분합 (최초는 배열 첫 값)

        for (int i = 0; i < nums.length; i++) {
            total += nums[i];                    // 현재 원소를 누적
            max = Math.max(max, total);          // 최대값 갱신

            // 누적합이 0보다 작으면 그 이전 구간은 무조건 손해 → 새로 시작
            if (total < 0) {
                total = 0;
            }
        }

        return max;  // 전체 중 가장 큰 연속 부분합 반환
    }
}