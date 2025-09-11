class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0, right = 0;
        for(int x : nums){
            left = Math.max(x, left);
            right += x;
        }
        while(left < right){
            int mid = left + (right - left) / 2;
            int total = 0;
            int cnt = 1;
            for(int x : nums){
                if(total + x > mid){
                    total = 0;
                    cnt++;
                }
                total += x;
            }
            if(cnt > k){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}