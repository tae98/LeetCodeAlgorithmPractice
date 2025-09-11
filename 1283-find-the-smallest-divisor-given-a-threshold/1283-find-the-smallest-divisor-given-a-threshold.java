class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = 0;
        for(int x : nums){
            right = Math.max(right, x);
        }
        while(left < right){
            int mid = left + (right - left) / 2;
            int total = 0;
            for(int x: nums){
                total += (x  + mid - 1) / mid;
            }
            if(total > threshold){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}