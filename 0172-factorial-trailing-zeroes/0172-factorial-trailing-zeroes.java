class Solution {
    public int trailingZeroes(int n) {
        if(n == 0){
            return 0;
        }

        int ans =0;
        int tmp = 5;
        int pow = 1;
        for(int i = 1; i <= n; i++){
            if(i / tmp == 5){
                tmp = i;
                ans += n/tmp + 1;
            }else if(i % 5 == 0){
                ans += 1;
            }
        }
        return ans;
    }
}