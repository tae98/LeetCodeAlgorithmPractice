class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> ans = new HashSet<>();
        for(int i : nums){
            if(!ans.add(i)){
                return true;
            }
        }
        return false;
    }
}