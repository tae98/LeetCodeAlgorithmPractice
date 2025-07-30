class Solution {
    public int findBestValue(int[] arr, int target) {
        // 1. 정렬: 이진 탐색과 prefix 최적화 가능성을 위해
        Arrays.sort(arr);

        // 2. value 탐색 범위 설정 (0 ~ max(arr))
        int left = 0, right = arr[arr.length - 1];

        // 3. 이진 탐색으로 value 후보를 줄여감
        while(left <= right){
            int mid = left + (right - left) / 2;

            // 4. mid를 기준으로 총합 계산 (value 이상은 잘라서 mid로 처리)
            int sum = 0;
            for(int num : arr){
                sum += Math.min(num, mid);
            }

            // 5. target보다 작으면 더 큰 value 탐색
            if(sum < target){
                left = mid + 1;
            }
            // 6. target보다 크거나 같으면 더 작은 value 탐색
            else{
                right = mid - 1;
            }
        }

        // 7. 탐색 종료 후, left/right 두 후보 중 실제 sum이 더 target에 가까운 쪽 선택
        int sumLeft = 0, sumRight = 0;
        for (int num : arr) {
            sumLeft += Math.min(num, left);
            sumRight += Math.min(num, right);
        }

        // 8. 정답 리턴 (tie-breaker: 작은 값 반환)
        if(Math.abs(sumLeft - target) < Math.abs(sumRight - target)){
            return left;
        }else{
            return right;
        }
    }
}
