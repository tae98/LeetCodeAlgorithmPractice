/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;

        // ✅ 이진 탐색: 조건 만족하는 가장 왼쪽 인덱스 (lower bound) 찾기
        while (left < right) {
            // 중간값 계산 (오버플로우 방지)
            int mid = left + (right - left) / 2;

            // \U0001f3af mid 버전이 bad면 → 정답이 될 수 있음 → 오른쪽 범위 줄이기 (mid 포함)
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                // ✅ mid 버전이 good이면 → 정답은 무조건 오른쪽에 있음
                left = mid + 1;
            }
        }

        // \U0001f51a 종료 시: left == right → 첫 번째 bad version
        return left;
    }
}
