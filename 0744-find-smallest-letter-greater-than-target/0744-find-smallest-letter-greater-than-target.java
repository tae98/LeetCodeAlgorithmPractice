class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;

        // ✅ 이진 탐색: target보다 큰 문자가 나오는 첫 위치 탐색
        while (left < right) {
            int mid = (left + right) / 2;

            // \U0001f3af mid 문자가 target보다 크면 → 정답 후보 → 왼쪽으로 범위 좁힘
            if (target < letters[mid]) {
                right = mid;
            } else {
                // \U0001f501 target보다 작거나 같으면 → 오른쪽으로 이동
                left = mid + 1;
            }
        }

        // \U0001f51a 이진 탐색 종료 후:
        // left는 target보다 큰 문자의 후보 위치 (혹은 배열 범위를 벗어남)

        // \U0001f4a1 만약 그런 문자가 없다면 → wrap-around → letters[0] 반환
        if (letters[left] <= target) {
            return letters[0];
        } else {
            return letters[left];
        }
    }
}
