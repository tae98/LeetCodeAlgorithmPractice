class Solution {
    public boolean isPalindrome(int x) {
        // if x is negative or x is not zero and x ends with 0
        if (x<0) return false;
        if (x != 0 && x % 10 == 0) return false;

        int reverse =0;
        //chcking only half of the x length
        while(x > reverse){
            int lastDigit = x % 10;
            //append reversed digit 
            reverse = (reverse * 10) + lastDigit;
            //to move to next digit
            x = x / 10;
        }
        // when x has even number legnth (ex.1221) || when x has odd number length(ex.12321)
        return (x == reverse) || (x == reverse / 10);
    }
}