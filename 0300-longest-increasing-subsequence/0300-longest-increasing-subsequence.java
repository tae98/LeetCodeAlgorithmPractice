class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        for(int x : nums){
            int idx = lowerBound(tmp, x);
            if(idx == tmp.size()){
                tmp.add(x);
            }else{
                tmp.set(idx, x);
            }
        }
        return tmp.size();
    }

    private int lowerBound(List<Integer> tmp, int num){
        int left = 0, right = tmp.size();
        while(left < right){
            int mid = left + (right - left) / 2;
            if(tmp.get(mid) >= num){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}