class Solution {
    public void reverseString(char[] s) {
        //s.length/2 for loop 
        //save left on tmp
        //let left = right 
        //give back left's original value to right using tmp (right = tmp)
        int len = s.length;
        for(int i =0; i < len/2; i++){
            char tmp = s[i];
            s[i] = s[len - 1 -i]; //s[i] = left, s[len - 1 -i] = right
            s[len -1 -i] = tmp;
        }
    }
}