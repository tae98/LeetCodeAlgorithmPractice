class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> window = new HashMap<>();
        
        while(right < s.length()){
            window.put(s.charAt(right),
             window.getOrDefault(s.charAt(right), 0) + 1);
            right++;
            
            if(right - left > p.length()){
                char lc = s.charAt(left);
                window.put(lc, window.get(lc) - 1);
                if(window.get(lc) == 0){
                    window.remove(lc);
                }
                left++;
            }
            
            if(right - left == p.length()){
                if(window.equals(map)){
                    ans.add(left);
                }

            }
            
            
        }
        return ans;
    }
}