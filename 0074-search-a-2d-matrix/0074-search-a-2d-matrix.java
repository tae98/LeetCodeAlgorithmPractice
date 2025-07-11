class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 행(row) 수와 열(col) 수 구하기
        int rows = matrix.length, cols = matrix[0].length;

        // 2차원 배열을 1차원처럼 보고 Binary Search
        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            // 가운데 인덱스 계산 (int overflow 방지 공식)
            int mid = left + (right - left) / 2;

            // mid 인덱스를 2차원 좌표로 변환
            int midVal = matrix[mid / cols][mid % cols];

            if (midVal == target) {
                return true; // 찾았을 경우
            } else if (midVal < target) {
                left = mid + 1; // 오른쪽 탐색
            } else {
                right = mid - 1; // 왼쪽 탐색
            }
        }

        return false; // 못 찾은 경우
    }
}
