class Solution {
    public int singleNumber(int[] nums) {
        int tmp =0;
        for(int each: nums){
            tmp = tmp ^ each;
        }
        return tmp;
    }
}