class Solution {
    public int lengthOfLastWord(String s) {
        String[] tmp = s.split(" ");
        String word = tmp[tmp.length-1];
        int ans = word.length();
        return ans;
    }
}