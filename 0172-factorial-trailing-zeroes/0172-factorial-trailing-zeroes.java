class Solution {
    public int trailingZeroes(int n) {
        int cnt =0;
        int currPowerOfFive =5;
        while(n >= currPowerOfFive){
            cnt += (n / currPowerOfFive);
            currPowerOfFive *=  5;
        }
        return cnt;
    }
}