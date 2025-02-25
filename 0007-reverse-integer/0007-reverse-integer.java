class Solution {
    public int reverse(int x) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        if (x == min || x == max){
            return 0;
        }
        int rev = 0;
        while(x != 0){
            int tmp = x % 10;
            if(rev > max/10 || rev < min/10){
                return 0;
            }
            rev = (rev * 10) + tmp;
            x = x/10;
        }
        return rev;
    }
}