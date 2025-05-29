class Solution {

    // 메인 함수: 문자열을 공백 단위로 단어 순서를 뒤집고 정리된 문자열을 반환
    public String reverseWords(String s) {
        // 문자열을 문자 배열로 변환 (in-place 조작을 위해)
        char[] arr = s.toCharArray();

        // 전체 문자열을 뒤집음 → 각 단어가 거꾸로 나오지만 순서도 바뀜
        reverse(arr, 0, arr.length - 1);  // 예: "the sky is blue" → "eulb si yks eht"

        // 각 단어를 다시 정방향으로 뒤집음 → 단어 순서만 바뀐 형태가 됨
        reverseWords(arr);               // 예: "eulb si yks eht" → "blue is sky the"

        // 공백 정리 (양쪽 공백 제거 + 중간에 여러 개의 공백은 하나로 만듦)
        return cleanSpaces(arr);         // 예: "  blue   is  sky the  " → "blue is sky the"
    }

    // 문자 배열의 특정 범위를 뒤집는 유틸리티 메서드
    private void reverse(char[] arr, int left, int right) {
        // 투 포인터로 좌우에서 교환
        while (left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

    // 각 단어 단위로 reverse()를 호출하여 단어만 정방향으로 복원
    private void reverseWords(char[] arr) {
        int left = 0;
        int right = 0;

        while (left < arr.length) {
            // 공백을 스킵하여 단어의 시작점을 찾음
            while (left < arr.length && arr[left] == ' ') {
                left++;
            }

            right = left;

            // 단어의 끝 위치 탐색
            while (right < arr.length && arr[right] != ' ') {
                right++;
            }

            // 현재 단어 reverse (left ~ right - 1)
            reverse(arr, left, right - 1);

            // 다음 단어로 이동
            left = right;
        }
    }

    // 공백을 정리: 앞뒤 공백 제거, 단어 사이 공백은 하나로
    private String cleanSpaces(char[] arr) {
        int left = 0;   // 실제 정리된 문자열을 기록할 위치
        int right = 0;  // 현재 읽고 있는 위치

        while (right < arr.length) {
            // 앞쪽 공백 무시
            while (right < arr.length && arr[right] == ' ') {
                right++;
            }

            // 단어 복사
            while (right < arr.length && arr[right] != ' ') {
                arr[left++] = arr[right++];
            }

            // 다음 단어 시작 전에 공백 하나 추가 (다음 단어가 있다면)
            while (right < arr.length && arr[right] == ' ') {
                right++;
            }

            // 단어가 더 있다면 공백 추가
            if (right < arr.length) {
                arr[left++] = ' ';
            }
        }

        // 잘라낸 후 정리된 문자열 반환
        return new String(arr, 0, left);
    }
}
