class Solution {
    public double myPow(double x, int n) {
        long num = Math.abs((long)n);
        double ans = 1;
        while(num != 0){
            if(num % 2 == 1){
                ans = ans * x;
                num = num - 1;
            }
            x = x * x;
            num = num / 2;
        }
        if(n < 0){
            ans = 1 / ans;
        }
        return ans;
    }
}