class Solution {
    public double myPow(double x, int n) {
        double ans =1;
        long num = Math.abs((long) n);

        if(x == 1){
            return 1;
        }

        while(num !=0){
            if (num % 2 == 1){// if n is odd num
                ans = ans * x;
                num = num-1;
            }
            x = x * x;
            num = num/2;
        }

        if(n < 0){
            ans = 1/ ans;
        }
        return ans;
    }
}