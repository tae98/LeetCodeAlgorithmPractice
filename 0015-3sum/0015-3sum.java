class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 결과 저장할 리스트
        List<List<Integer>> ans = new ArrayList<>();

        // 1. 배열 정렬
        Arrays.sort(nums);

        // 2. 첫 번째 원소를 고정 (i)
        for (int i = 0; i < nums.length - 2; i++) {

            // 같은 값으로 시작하는 i는 스킵 (중복 방지)
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;             // 두 번째 포인터
            int right = nums.length - 1;  // 세 번째 포인터

            // 3. 투 포인터 탐색
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // 합이 0인 경우 triplet 저장
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    ans.add(triplet);

                    // left 중복 제거
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // right 중복 제거
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // 다음 후보 탐색을 위해 포인터 이동
                    left++;
                    right--;

                } else if (sum < 0) {
                    // 합이 작으면 left 증가
                    left++;
                } else {
                    // 합이 크면 right 감소
                    right--;
                }
            }
        }

        return ans;
    }
}
