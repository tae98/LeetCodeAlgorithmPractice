class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();
        
        Arrays.sort(nums);
        int start = lowerBound(nums, target);
        int end = upperBound(nums, target);
        System.out.println(start);
        System.out.println(end);
        while(start < end){
            ans.add(start);
            start++;
        }
        return ans;
    }
    private Integer lowerBound(int[]nums, int target){
       int left = 0, right = nums.length -1;
       while(left<=right){
        int mid = left + (right - left) / 2;
        if(nums[mid] >= target){
            right = mid - 1;
        }else{
            left = mid + 1;
        }
       }
       return left;
    }

    private Integer upperBound(int[]nums, int target){
       int left = 0, right = nums.length -1;
       while(left<=right){
        int mid = left + (right - left) / 2;
        if(nums[mid] <= target){
            left = mid + 1;
        }else{
            right = mid - 1;
        }
       }
       return left;
    }
}