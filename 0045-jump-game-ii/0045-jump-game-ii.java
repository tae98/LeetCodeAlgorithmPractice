class Solution {
    public int jump(int[] nums) {
        int cnt = 0;
        int start= 0;
        int end = 0;

        while(end < nums.length -1){
            int maxJump=0;
            for(int j = start; j <= end; j++){
                maxJump = Math.max(maxJump,j+ nums[j]);
            }
            start = end + 1;
            end = maxJump;
            cnt++;
        }
        return cnt;
    }
}


