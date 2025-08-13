class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int low = 0;        // 현재까지 사용 가능한 최솟값 (가장 작은 남은 수)
        int hi  = n;        // 현재까지 사용 가능한 최댓값 (가장 큰 남은 수)
        int[] tmp = new int[n + 1]; // 결과 순열 [0..n] 총 n+1개

        // s[i]가 'I'면 오름: 더 작은 수를 먼저 배치 (low 사용)
        // s[i]가 'D'면 내림: 더 큰 수를 먼저 배치 (hi 사용)
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                tmp[i] = low++;   // 배치 후 low를 1 증가 (post-increment)
            } else { // 'D'
                tmp[i] = hi--;    // 배치 후 hi를 1 감소
            }
        }
        // 마지막 남은 하나는 low == hi 이므로 둘 중 아무거나 사용 가능
        tmp[n] = low;
        return tmp;
    }
}
