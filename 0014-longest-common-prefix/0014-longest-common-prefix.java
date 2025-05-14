class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null) return "";
        
        Arrays.sort(strs);
        String first = strs[0],last = strs[strs.length - 1];
        StringBuilder ans = new StringBuilder();

        for(int i =0; i < first.length(); i++){
            if(first.charAt(i) == last.charAt(i)){
                ans.append(first.charAt(i));
            }else{
                break;
            }
        }

        return ans.toString();
    }
}