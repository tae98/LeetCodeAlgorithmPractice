class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        //알파벳 총 갯수와 같은 크기의 Array생성(모두 초기값은 0)
        int[] cnt = new int[26];

        for(int i = 0; i < s.length(); i++){
            //특정 알파벳 cnt상 위치(index)의 값을 s에 등장하면 ++ 
            cnt[s.charAt(i) - 'a']++;
           
        }

        for(int i = 0; i < t.length(); i++){
            //특정 알파벳 cnt상 위치(index)의 값을 t에 등장할시 --
            cnt[t.charAt(i) - 'a']--;
            //이미 위에서 s의 알파벳으로 cnt는 업데이트됨
            //만약 t만 존재하거나 t에 더많이존재할시(anagram X) 값은 < 0
            if(cnt[t.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}