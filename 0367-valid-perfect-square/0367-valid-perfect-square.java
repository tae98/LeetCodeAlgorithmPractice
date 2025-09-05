class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        while(left <= right){
            int mid = left + (right - left) / 2;
            long sqr = (long) mid * mid;
            if(sqr == num){
                return true;
            }

            if(sqr > num){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
}