class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        
        int ans = 0;
        for(int i = 0; i < s.length() - 1; i++){
            char cur = s.charAt(i);
            char next = s.charAt(i + 1);
            if(roman.get(cur) < roman.get(next)){
                ans -= roman.get(cur);
            }else{
                ans += roman.get(cur);
            }
        }
        ans += roman.get(s.charAt(s.length() - 1));
        return ans;
    }
}