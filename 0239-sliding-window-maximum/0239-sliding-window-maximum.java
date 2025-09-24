class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> tmp = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        int cnt = 0;
        for(int i = 0; i < nums.length; i++){
            if(!tmp.isEmpty() && tmp.peek() <= i - k){
                tmp.removeFirst();
            }
            while(!tmp.isEmpty() && nums[tmp.getLast()] < nums[i]){
                tmp.removeLast();
            }
            tmp.add(i);
            if(i >= k - 1){
                ans[cnt] = nums[tmp.getFirst()];
                cnt++;
            }
        }
        return ans;
    }
}