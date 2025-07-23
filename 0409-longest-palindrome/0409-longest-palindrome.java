class Solution {
    public int longestPalindrome(String s) {
        // 각 문자의 출현 횟수를 저장할 map
        int[] arr = new int[128];
        int ans = 0;

        // 문자 빈도 계산
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c]++; 
        }

        boolean hasOdd = false;  // 홀수 개수가 존재하는지 여부

        // 각 문자 빈도 기준으로 처리
        for (int val : arr) {
            if (val % 2 == 0) {
                ans += val;           // 짝수면 전부 사용
            } else {
                ans += val - 1;       // 홀수면 1개 남기고 짝수만 사용
                hasOdd = true;        // 중앙에 하나 쓸 수 있다는 표시
            }
        }

        // 중앙에 하나 더 추가할 수 있으면 +1
        if (hasOdd) ans += 1;

        return ans;
    }
}
