class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;  // 전체 연료 차익 누적합 (한 바퀴 돌 수 있는지 여부)
        int curr = 0;   // 현재 출발점 기준 누적 연료 상태
        int idx = 0;    // 현재 살아남은 출발점 후보

        for (int i = 0; i < gas.length; i++) {
            int gain = gas[i] - cost[i];  // 현재 지점에서 얻는 순수 연료 이득
            total += gain;                // 전체 가능성 판단용 누적합
            curr += gain;                 // 현재 출발지에서의 잔여 연료

            // 연료가 바닥났다면 이 지점까지 오기 실패 → 출발지 탈락
            if (curr < 0) {
                idx = i + 1;  // 다음 지점부터 새 출발 시도
                curr = 0;     // 누적 연료 초기화
            }
        }

        // 전체 연료 총합이 부족하면 불가능, 아니면 idx가 유일한 정답
        return total >= 0 ? idx : -1;
    }
}
