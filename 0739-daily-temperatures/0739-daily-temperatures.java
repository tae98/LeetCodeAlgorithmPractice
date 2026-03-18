class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        int n = temperatures.length;
        Stack<Integer> stk = new Stack<>();

        for(int i = 0; i < n ; i++){
            while(!stk.isEmpty() && temperatures[i] > temperatures[stk.peek()]){
                int tmp = stk.pop();
                ans[tmp] = i - tmp;
            }
            stk.push(i);
        }
        return ans;
    }
}