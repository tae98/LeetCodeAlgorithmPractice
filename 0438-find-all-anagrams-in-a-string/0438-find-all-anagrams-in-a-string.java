class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] pCount = new int[26];
        int[] sWindow = new int[26];

        for(char c : p.toCharArray()){
            pCount[c - 'a']++;
        }

        int left = 0;
        List<Integer> ans = new ArrayList<>();
        
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            sWindow[c - 'a']++;

            if(right - left + 1 == p.length()){
                if(Arrays.equals(pCount, sWindow)){
                    ans.add(left);
                }
                sWindow[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return ans;
    }
}