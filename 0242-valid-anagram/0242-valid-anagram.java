class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()){
            return false;
        }
       Map<Character, Integer> mapS = new HashMap<>();
       Map<Character, Integer> mapT = new HashMap<>();

       for(int i = 0; i < s.length(); i++){
        char cs = s.charAt(i);
        char ct = t.charAt(i);
        //getOrDefault 값이 존재 하면 값을가져옴
        //없을 시 원하는값으로 초기값 설정 
        mapS.put(cs, mapS.getOrDefault(cs, 0) + 1);
        mapT.put(ct, mapT.getOrDefault(ct, 0) +1);
       }
       
       return mapS.equals(mapT);
    }
}