class Solution {
    public int trailingZeroes(int n) {
        if(n == 5){
            return 1;
        }

        int ans =0;
        int tmp = 5;
        while(tmp <= n){
            ans += n / tmp;
            tmp = tmp * 5;
        }
        return ans;
    }
}