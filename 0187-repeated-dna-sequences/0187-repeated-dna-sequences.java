class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        for(int i = 0; i < s.length() - 10 ; i++){
            String sub = s.substring(i, i + 10);
            //Set.add(sub) -> 세트에 sub가 중복되지않으면 true 반환후 sub 자동으로 Set에추가
            //만약 이미 존재할경우 false반환 
            repreated.add(sub);
        }
        return new ArrayList<>(repeated);
    }
}