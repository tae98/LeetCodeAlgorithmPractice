class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, len = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, i);
                len++;
            }else{
                len = 0;
                i = map.get(c);
                map.clear();
            }
            max = Math.max(max, len);
        }
        return max;
    }
}