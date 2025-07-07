class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;

        // 이진 탐색 시작
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // \U0001f9e0 mid * mid는 int 범위를 벗어날 수 있으므로 long으로 처리
            long square = (long) mid * mid;

            if (square == num) {
                return true; // 완전제곱수인 경우
            } else if (square < num) {
                left = mid + 1; // 제곱이 작으면 더 큰 수 탐색
            } else {
                right = mid - 1; // 제곱이 크면 더 작은 수 탐색
            }
        }

        // 반복문 종료 후에도 정답 못 찾은 경우 false
        return false;
    }
}
