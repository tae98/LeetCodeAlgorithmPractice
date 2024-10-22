class Solution {
    public int removeDuplicates(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        int cnt =0;
        for(int i =0; i<nums.length; i++){
            // if(!tmp.contains(nums[i]) && i == nums.length-1){
            //     tmp.add(nums[i]);
            //     nums[cnt] = nums[i];
            // }
            if(!tmp.contains(nums[i])){
                tmp.add(nums[i]);
                nums[cnt] = nums[i];
                cnt++;
            }else{
                continue;
            }
        }

        return cnt;
    }
}