class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];

        // 모든 아이는 최소 1개는 사탕을 받아야 한다
        Arrays.fill(candies, 1);

        // 왼 → 오 방향: rating이 증가하면 사탕도 증가
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // 오 → 왼 방향: rating이 증가하면 사탕도 증가
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                // 기존 값보다 더 큰 값만 유지
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // 전체 사탕 합산
        int ans = 0;
        for (int candy : candies) {
            ans += candy;
        }

        return ans;
    }
}
