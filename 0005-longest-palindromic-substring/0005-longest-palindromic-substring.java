class Solution {
    // 전체 문자열에서 발견한 최장 팰린드롬 부분의 시작과 끝 인덱스를 저장
    int start = 0, end = 0;

    public String longestPalindrome(String s) {
        // 문자열의 모든 문자를 중심으로 팰린드롬 확장 시도
        for (int i = 0; i < s.length(); i++) {
            // 1. 홀수 길이 팰린드롬 (중심이한글자 i인 경우, 예: "aba")
            expandAroundCenter(s, i, i);

            // 2. 짝수 길이 팰린드롬 (중심이두글자 i, i+1인 경우, 예: "abba")
            expandAroundCenter(s, i, i + 1);
        }

        // 최장 팰린드롬 부분 문자열을 원본 문자열에서 잘라서 반환
        // end는 포함 범위이므로 +1 필요
        return s.substring(start, end + 1);
    }

    // 중심(left, right)을 기준으로 좌우로 팰린드롬 확장하는 함수
    private void expandAroundCenter(String s, int left, int right) {
        // 팰린드롬 조건을 만족하는 동안 확장
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // while 종료 후에는 범위를 한 칸 초과했으므로 보정
        left = left + 1;
        right = right - 1;

        // 현재까지 찾은 팰린드롬보다 더 긴 경우 start/end 갱신
        if (end - start + 1 < right - left + 1) {
            start = left;
            end = right;
        }
    }
}
