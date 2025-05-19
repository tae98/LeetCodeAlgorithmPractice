public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        // 전처리: 가운데 # 삽입 + 시작/끝 문자로 ^, $
        String T = preprocess(s);  // 예: "abba" → "^#a#b#b#a#$"
        int n = T.length();
        int[] P = new int[n]; // P[i]: 중심 i에서의 반지름

        int center = 0, right = 0;
        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i;

            if (i < right) {
                P[i] = Math.min(right - i, P[mirror]);
            }

            // 중심 i에서 확장
            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                P[i]++;
            }

            // 오른쪽 경계 갱신
            if (i + P[i] > right) {
                center = i;
                right = i + P[i];
            }
        }

        // 최대 길이와 중심 위치 찾기
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }

        // 원래 문자열에서 시작 인덱스 추출
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }

    // 입력 문자열 전처리 함수
    private String preprocess(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("^");
        for (int i = 0; i < s.length(); i++) {
            sb.append("#");
            sb.append(s.charAt(i));
        }
        sb.append("#$");
        return sb.toString();
    }
}
