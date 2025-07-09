class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        // 가능한 최소 divisor는 1, 최대는 배열의 최댓값
        int left = 1, right = 0;
        for (int num : nums) {
            right = Math.max(right, num);
        }

        // 이진 탐색으로 최소 divisor 찾기
        while (left < right) {
            int mid = left + (right - left) / 2;
            int sum = 0;

            // 각 원소를 mid로 나눈 올림값의 합 계산
            for (int num : nums) {
                sum += (num + mid - 1) / mid; // == Math.ceil(num / mid)
            }

            // threshold를 초과하면 divisor가 너무 작음 → 더 크게
            if (sum > threshold) {
                left = mid + 1;
            } 
            // 조건 만족 → 더 작은 divisor도 가능성 있음 → 줄이자
            else {
                right = mid;
            }
        }

        // left == right: 조건을 만족하는 최소 divisor
        return left;
    }
}
