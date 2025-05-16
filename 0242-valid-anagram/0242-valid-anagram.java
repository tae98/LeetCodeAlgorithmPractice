class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        //알파벳 총 갯수와 같은 크기의 Array생성(모두 초기값은 0)
        int[] cnt = new int[26];

        for(int i = 0; i < s.length(); i++){
            //특정 알파벳 cnt상 위치(index)의 값을 s에 등장하면 ++ t에 등장할시 --
            cnt[s.charAt(i) - 'a']++;
            cnt[t.charAt(i) - 'a']--;
        }

        for(int each : cnt){
            //초기값이 0이기 떄문에 모든 값들은 anagram일시 0이여야함
            if(each != 0){
                return false;
            }
        }
        return true;
    }
}