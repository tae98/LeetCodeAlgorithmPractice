class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // \U0001f4e6 최소 용량은 weights 중 최대값 이상이어야 함
        // \U0001f4e6 최대 용량은 모든 박스를 하루에 다 보내는 경우 = 전체 합
        int min = 0;
        int max = 0;
        for (int weight : weights) {
            min = Math.max(min, weight); // 최소 무게는 가장 무거운 박스
            max += weight;               // 최대 무게는 전체 합
        }

        int left = min, right = max;

        // \U0001f69a 이진 탐색 시작: 가능한 최소 운송 용량을 탐색
        while (left < right) {
            int mid = left + (right - left) / 2;  // 현재 중간 운송 용량
            int day = 1;      // 최소 하루는 필요
            int total = 0;    // 하루 동안 누적한 무게

            for (int weight : weights) {
                // 현재 무게까지 더하면 mid 초과 → 하루 증가
                if (total + weight > mid) {
                    total = 0;
                    day ++;
                }
                total += weight; // 무게 누적
            }

            // \U0001f3af 일수가 주어진 days보다 적으면 → mid 줄여보기
            if (day <= days) {
                right = mid;
            } else {
                // \U0001f4c8 일수가 너무 많으면 → 용량 늘려야 함
                left = mid + 1;
            }
        }

        // \U0001f3c1 최소한의 용량 리턴
        return left;
    }
}
