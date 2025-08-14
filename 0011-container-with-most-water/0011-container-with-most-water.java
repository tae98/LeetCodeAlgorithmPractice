class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int best = 0;

        while (left < right) {
            // 현재 후보 넓이
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int cur = width * h;

            // 러닝 최대값 갱신
            if (cur > best) best = cur;

            // 개선 가능성이 있는 '낮은 쪽' 포인터 이동
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return best;
    }
}
