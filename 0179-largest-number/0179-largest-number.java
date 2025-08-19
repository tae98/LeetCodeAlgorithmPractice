class Solution {
    public String largestNumber(int[] nums) {

        // 1. int 배열 → String 배열로 변환
        //    이유: 숫자끼리 정렬이 아니라 "문자열 연결했을 때" 크기를 비교해야 하기 때문
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // 2. 정렬: (b+a) vs (a+b)를 비교
        //    두 문자열 a, b를 이어붙였을 때,
        //    a가 앞에 오는 경우(a+b)와 b가 앞에 오는 경우(b+a) 중
        //    더 큰 쪽을 앞에 배치하도록 정렬
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // 3. 모든 수가 0일 경우 → "0" 반환
        //    예: [0,0] 이면 "00"이 아니라 "0"이 정답
        if (arr[0].equals("0")) {
            return "0";
        }

        // 4. 정렬된 문자열을 모두 이어붙이기
        StringBuilder sb = new StringBuilder();
        for (String x : arr) {
            sb.append(x);
        }

        // 5. 최종 문자열 반환
        return sb.toString();
    }
}
