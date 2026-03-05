class Solution {
    public int[] plusOne(int[] digits) {
        int tmp = 0;
        int last = digits.length - 1;
        digits[last]++;
        if(digits[last] == 10){
            digits[last] = 0;
            tmp = 1;
        }

      for(int i = digits.length - 2; i >= 0; i--){
        if(tmp == 1 && digits[i] != 9){
            digits[i] = tmp + digits[i];
            tmp = 0;
        }else if (tmp == 1 && digits[i] == 9){
            digits[i] = 0;
            tmp = 1;
        }

      }
      if(tmp == 1){
        int[] ans = new int[digits.length +1];
        ans[0] = 1;
        return ans;
      }

      return digits;
    }
}