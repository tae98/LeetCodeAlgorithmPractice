class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // \U0001f34c 바나나 더미 중 최대값 찾기 → upper bound로 사용
        int max = 0;
        for (int num : piles) {
            max = Math.max(max, num);
        }

        int left = 1;        // 최소 속도 (1시간에 1개는 먹어야 하니까 0은 X)
        int right = max;     // 최대 속도 (한 더미 전체를 1시간에 먹는 경우)

        // \U0001f50d 이진 탐색 시작
        while (left < right) {
            int mid = left + (right - left) / 2;  // 중간 속도
            int hour = 0;

            // ⏱️ mid 속도로 바나나 먹을 때 총 걸리는 시간 계산
            for (int num : piles) {
                // \U0001f34c 한 더미씩 먹는 데 걸리는 시간 계산
                hour += (num + mid - 1) / mid;  // 올림처리 공식
            }

            // \U0001f9d0 시간이 h보다 작거나 같으면 속도 줄여보기 (더 최적화 가능)
            if (hour <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // ✅ 최소 가능한 먹는 속도 반환
        return left;
    }
}
