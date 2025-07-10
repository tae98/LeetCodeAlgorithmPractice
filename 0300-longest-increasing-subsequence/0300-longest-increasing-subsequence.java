class Solution {
    public int lengthOfLIS(int[] nums) {
        // LIS의 끝 값들만 저장하는 리스트
        List<Integer> tmp = new ArrayList<>();

        for (int num : nums) {
            // 현재 num이 들어갈 수 있는 위치(lower bound)를 이진탐색으로 찾음
            int idx = lowerBound(tmp, num);

            // idx가 리스트 끝이면 새로운 증가 수열 요소 추가
            if (idx == tmp.size()) {
                tmp.add(num);
            } else {
                // 아니라면 기존 위치 값을 더 작은 값으로 교체해줌
                tmp.set(idx, num);
            }
        }
        // 리스트 길이가 곧 LIS의 길이
        return tmp.size();
    }

    // lowerBound: tmp 리스트에서 num보다 크거나 같은 첫 번째 인덱스를 반환
    private int lowerBound(List<Integer> tmp, int num) {
        int left = 0, right = tmp.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (tmp.get(mid) >= num) {
                right = mid; // num보다 같거나 큰 값 → 왼쪽으로 탐색
            } else {
                left = mid + 1; // num보다 작으면 오른쪽으로 이동
            }
        }
        return left;
    }
}
