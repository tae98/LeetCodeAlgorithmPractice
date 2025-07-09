class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0, right = 0;

        // ✅ 최소값: 배열 중 가장 큰 수 (이보다 작은 합으로는 불가능)
        // ✅ 최대값: 배열 전체 합 (한 번도 안 나눴을 경우)
        for(int num : nums){
            left = Math.max(left, num);
            right += num;
        }

        // \U0001f9e0 이진 탐색으로 최소 가능한 최대값을 찾는다
        while(left < right){
            int mid = left + (right - left) / 2;

            int total = 0;
            int cnt = 1;  // 배열을 나눈 횟수 (최소 1개)

            // \U0001f3af 현재 mid로 배열을 나눌 수 있는지 그리디하게 체크
            for(int num: nums){
                if(total + num > mid){
                    // mid를 초과하면 잘라야 함
                    total = num;
                    cnt++;
                }else{
                    total += num;
                }
            }

            // ✅ mid 값으로 k개 이하로 쪼갤 수 있음 → 더 작은 최대값 가능
            if(cnt <= k){
                right = mid;
            }else{ // ❌ 너무 많이 쪼갬 → mid가 작음
                left = mid + 1;
            }
        }

        return left;  // 최소 가능한 최대 서브배열 합
    }
}
