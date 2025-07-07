class Solution {
    public int mySqrt(int x) {
        int left = 1, right = x;
        while(left <= right){
            int mid = left + (right - left)/2;
            long square = (long) mid * mid;
            if(square == x){
                return mid;
            }else if(square > x){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }
}